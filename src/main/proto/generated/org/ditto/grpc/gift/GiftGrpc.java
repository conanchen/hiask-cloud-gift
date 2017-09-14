package org.ditto.grpc.gift;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The gift service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.5.0)",
    comments = "Source: gift.proto")
public final class GiftGrpc {

  private GiftGrpc() {}

  public static final String SERVICE_NAME = "Gift";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.ditto.grpc.gift.GiftOuterClass.GiftRequest,
      org.ditto.grpc.gift.GiftOuterClass.GiftResponse> METHOD_LIST_GIFTS =
      io.grpc.MethodDescriptor.<org.ditto.grpc.gift.GiftOuterClass.GiftRequest, org.ditto.grpc.gift.GiftOuterClass.GiftResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "Gift", "ListGifts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.gift.GiftOuterClass.GiftRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.gift.GiftOuterClass.GiftResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GiftStub newStub(io.grpc.Channel channel) {
    return new GiftStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GiftBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GiftBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GiftFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GiftFutureStub(channel);
  }

  /**
   * <pre>
   * The gift service definition.
   * </pre>
   */
  public static abstract class GiftImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifts whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifts.
     * </pre>
     */
    public void listGifts(org.ditto.grpc.gift.GiftOuterClass.GiftRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.gift.GiftOuterClass.GiftResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_GIFTS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIST_GIFTS,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.ditto.grpc.gift.GiftOuterClass.GiftRequest,
                org.ditto.grpc.gift.GiftOuterClass.GiftResponse>(
                  this, METHODID_LIST_GIFTS)))
          .build();
    }
  }

  /**
   * <pre>
   * The gift service definition.
   * </pre>
   */
  public static final class GiftStub extends io.grpc.stub.AbstractStub<GiftStub> {
    private GiftStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GiftStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GiftStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GiftStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifts whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifts.
     * </pre>
     */
    public void listGifts(org.ditto.grpc.gift.GiftOuterClass.GiftRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.gift.GiftOuterClass.GiftResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_GIFTS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The gift service definition.
   * </pre>
   */
  public static final class GiftBlockingStub extends io.grpc.stub.AbstractStub<GiftBlockingStub> {
    private GiftBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GiftBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GiftBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GiftBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifts whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifts.
     * </pre>
     */
    public java.util.Iterator<org.ditto.grpc.gift.GiftOuterClass.GiftResponse> listGifts(
        org.ditto.grpc.gift.GiftOuterClass.GiftRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_GIFTS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The gift service definition.
   * </pre>
   */
  public static final class GiftFutureStub extends io.grpc.stub.AbstractStub<GiftFutureStub> {
    private GiftFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GiftFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GiftFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GiftFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIST_GIFTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GiftImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GiftImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GIFTS:
          serviceImpl.listGifts((org.ditto.grpc.gift.GiftOuterClass.GiftRequest) request,
              (io.grpc.stub.StreamObserver<org.ditto.grpc.gift.GiftOuterClass.GiftResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class GiftDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.ditto.grpc.gift.GiftOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GiftGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GiftDescriptorSupplier())
              .addMethod(METHOD_LIST_GIFTS)
              .build();
        }
      }
    }
    return result;
  }
}
