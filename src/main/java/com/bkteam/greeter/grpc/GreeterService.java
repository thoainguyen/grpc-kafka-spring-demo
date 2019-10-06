package com.bkteam.greeter.grpc;


import com.bkteam.greeter.GreeterGrpc;
import com.bkteam.greeter.GreeterOuterClass;
import com.bkteam.greeter.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.stub.StreamObserver;

@Slf4j
@GRpcService(interceptors = { LogInterceptor.class })
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        String message = "Hello " + request.getName();
        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage(message);

        kafkaProducer.sendMessage("kafka-demo-group.topic1", replyBuilder.toString());

        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        System.out.println("Returning " +message);
    }
}