package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRespositoryV5 orderRespository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRespositoryV5 orderRespository, LogTrace trace) {
        this.orderRespository = orderRespository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRespository.save(itemId);
            return null;
        });
    }

}
