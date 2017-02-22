package eventbus;


import io.vertx.core.AbstractVerticle;

public class EventBusReceiverVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("anAddress", message -> {
            System.out.println("received message body() = " + message.body());
        });
    }
}
