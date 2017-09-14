package org.ditto.gift;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerInterceptor;

import io.grpc.stub.StreamObserver;
import org.ditto.grpc.gift.GiftGrpc;
import org.ditto.grpc.gift.GiftOuterClass;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationSpringBoot.class, TestConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GiftGrpcServiceTests {


    private ManagedChannel channel;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    @Qualifier("globalInterceptor")
    private ServerInterceptor globalInterceptor;


    @Before
    public void setup() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext(true)
                .build();
    }

    @After
    public void tearDown() {
        channel.shutdown();
    }

    @Test
    public void interceptorsTest() throws ExecutionException, InterruptedException {

        GiftGrpc.newStub(channel)
                .listGifts(GiftOuterClass.GiftRequest.newBuilder().setPageSize(10).build(),
                        new StreamObserver<GiftOuterClass.GiftResponse>() {
                            @Override
                            public void onNext(GiftOuterClass.GiftResponse value) {

                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onCompleted() {

                            }
                        });

        GiftGrpc.newBlockingStub(channel)
                .listGifts(GiftOuterClass.GiftRequest.newBuilder().setPageSize(10).build())
                .forEachRemaining(new Consumer<GiftOuterClass.GiftResponse>() {
                    @Override
                    public void accept(GiftOuterClass.GiftResponse giftResponse) {

                    }
                });


        // global interceptor should be invoked once on each service
        Mockito.verify(globalInterceptor, Mockito.times(2))
                .interceptCall(Mockito.any(), Mockito.any(), Mockito.any());


        // log interceptor should be invoked only on GreeterService and not CalculatorService
        outputCapture.expect(CoreMatchers.containsString(GiftGrpc.METHOD_LIST_GIFTS.getFullMethodName()));

    }

}
