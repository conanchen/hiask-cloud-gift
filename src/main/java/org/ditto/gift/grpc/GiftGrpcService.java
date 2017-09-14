package org.ditto.gift.grpc;

import io.grpc.stub.StreamObserver;
import org.ditto.gift.model.Gift;
import org.ditto.gift.repository.GiftRepository;
import org.ditto.grpc.gift.GiftGrpc;
import org.ditto.grpc.gift.GiftOuterClass;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

@GRpcService(interceptors = {LogInterceptor.class})
public class GiftGrpcService extends GiftGrpc.GiftImplBase {
    @Autowired
    private GiftRepository giftRepository;

    @Override
    public void listGifts(GiftOuterClass.GiftRequest request, StreamObserver<GiftOuterClass.GiftResponse> responseObserver) {

        Iterable<Gift> giftIterable = giftRepository.findAll();
        Iterator<Gift> giftIterator = giftIterable.iterator();
        int count = 0;
        while (giftIterator.hasNext() && count < request.getPageSize()) {
            Gift gift = giftIterator.next();
            GiftOuterClass.GiftResponse.Builder replyBuilder = GiftOuterClass.GiftResponse
                    .newBuilder()
                    .setCodepoint(gift.codepoint)
                    .setCodepointu16(gift.codepointu16)
                    .setGroupId(gift.groupId)
                    .setSubgroupId(gift.subgroupId)
                    .setName(gift.name)
                    .setSequence(gift.sequence)
                    .setLastUpdated(gift.lastUpdated)
                    .setActive(gift.active);
            responseObserver.onNext(replyBuilder.build());
            count++;
        }
        responseObserver.onCompleted();
    }
}
