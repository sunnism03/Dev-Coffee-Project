package com.grepp.CoffeeProject.Orders.service;

import com.grepp.CoffeeProject.OrderItems.converter.OrderItemsConverter;
import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsRequestDTO;
import com.grepp.CoffeeProject.OrderItems.repository.OrderItemsRepository;
import com.grepp.CoffeeProject.Orders.converter.OrdersConverter;
import com.grepp.CoffeeProject.Orders.domain.OrderStatus;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.dto.OrdersResponseDTO;
import com.grepp.CoffeeProject.Orders.repository.OrdersRepository;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.repository.ProductsRepository;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrdersService {

    @Autowired
    private OrdersConverter ordersConverter;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private OrderItemsConverter orderItemsConverter;

    @Transactional
    public void createOrder(OrdersRequestDTO.OrderDTO orderDTO){
        Orders order = ordersConverter.toOrdersEntity(orderDTO);
        ordersRepository.save(order);

        List<OrderItems> orderItemsList = order.getOrderItemsList();
        for(OrderItems orderItem : orderItemsList) {
            UUID productId = orderItem.getProducts().getProductId();
            int productsNum = orderItem.getQuantity();
            Products product = productsRepository.findByProductId(productId);
            product.setStock(product.getStock() - productsNum);
            productsRepository.save(product);
        }
    }

    @Transactional
    public List<OrdersResponseDTO.OrderDetailDTO> getOrderDetail(OrdersRequestDTO.OrderEmailDTO email) {
        List<Orders> ordersList = ordersRepository.findAllByEmailOrderByCreatedAtDesc(email.getEmail());
        List<OrdersResponseDTO.OrderDetailDTO> ordersDetailDTOs = new ArrayList<>();
        for(Orders order : ordersList) {
            OrdersResponseDTO.OrderDetailDTO orderDetailDTO = ordersConverter.toOrderDTO(order);
            ordersDetailDTOs.add(orderDetailDTO);
        }
        return ordersDetailDTOs;
    }

    @Transactional
    @Scheduled(cron = "0 0 14 * * ?")
    public void OrderStatusScheduler() {
        LocalDateTime start = LocalDate.now().minusDays(1).atTime(14, 0, 0);
        LocalDateTime end = LocalDate.now().atTime(13, 59, 59);
        List<Orders> shippingOrders = ordersRepository.findByCreatedAtBetween(start, end);

        for(Orders shippingOrder : shippingOrders) {
            shippingOrder.setOrderStatus(OrderStatus.SHIPPING);
            ordersRepository.save(shippingOrder);
        }
    }

    @Transactional
    public void deleteOrder(UUID orderId) {
        Orders order = ordersRepository.findByOrderId(orderId);
        if (order.getOrderStatus().equals(OrderStatus.ORDER_COMPLETE)) {
            orderItemsRepository.deleteAllByOrders(order);
            System.out.println("orderItem 삭제");
            ordersRepository.deleteById(orderId);
            System.out.println("order 삭제");
        }
    }

    @Transactional
    public void updateOrder(UUID orderId, OrdersRequestDTO.OrderDTO updateDTO) {
        Orders order = ordersRepository.findByOrderId(orderId);
        System.out.println(order);

        if (order.getOrderStatus().equals(OrderStatus.ORDER_COMPLETE)) {
            order.setEmail(updateDTO.getEmail());
            order.setAddress(updateDTO.getAddress());
            order.setPostcode(updateDTO.getPostcode());

            List<OrderItems> beforeOrderItems = order.getOrderItemsList();

            // 기존 OrderItems 삭제 (연관 관계 정리)
            order.getOrderItemsList().clear();
            ordersRepository.saveAndFlush(order);

            for(OrderItems beforeOrderItem : beforeOrderItems) {
                UUID productId = beforeOrderItem.getProducts().getProductId();
                int productsNum = beforeOrderItem.getQuantity();
                Products product = productsRepository.findByProductId(productId);
                product.setStock(product.getStock() + productsNum);
                productsRepository.save(product);
                System.out.println(product);
                System.out.println("product stock 복구");
            }

            List<OrderItemsRequestDTO.OrderItemsDTO> updateOrderItemsDTOs = updateDTO.getOrderItemsDTOs();
            List<OrderItems> updateOrderItems = orderItemsConverter.toOrderItemsList(updateOrderItemsDTOs);
            updateOrderItems.forEach(orderItem -> orderItem.setOrders(order));  // 관계 설정
            order.setOrderItemsList(updateOrderItems);
            ordersRepository.save(order);

            for(OrderItems orderItem : updateOrderItems) {
                UUID productId = orderItem.getProducts().getProductId();
                int productsNum = orderItem.getQuantity();
                Products product = productsRepository.findByProductId(productId);
                product.setStock(product.getStock() - productsNum);
                productsRepository.save(product);
                System.out.println(product);
                System.out.println("product stock 수정 완료");
            }
        }
    }
}
