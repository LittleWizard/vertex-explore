package first;


import io.vertx.core.AbstractVerticle;

public class BasicVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        System.out.println("BasicVerticle started successfully");
        //Thread.sleep(4000);
        vertx.deployVerticle(new SecondVerticle());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("BasicVerticle stopped successfully");
    }

}
