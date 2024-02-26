package org.example.job;

import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledJobService {
    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "${job.update-order-status-and-progress.cron-expression}")
    public void updateOrderStatusAndProgress() {
        orderService.updateOrderStatusAndProgress();
    }
}
