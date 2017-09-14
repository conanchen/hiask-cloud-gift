package org.ditto.gift.data;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.ditto.gift.model.Gift;
import org.ditto.gift.model.Giftgroup;
import org.ditto.gift.repository.GiftRepository;
import org.ditto.gift.repository.GiftgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务启动执行
 */
@Component
@Slf4j
public class GiftDataImportRunner implements CommandLineRunner {

    @Autowired
    private Ignite ignite;
    @Autowired
    private GiftgroupRepository giftgroupRepository;
    @Autowired
    private GiftRepository giftRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Start GiftDataImportRunner服务启动执行，执行Gift数据导入");
        List<Object> giftDatas = GiftTextConverter.processGiftText(GiftText.giftLines);
        for (Object giftData : giftDatas) {
            if (giftData instanceof Giftgroup) {
                Giftgroup giftgroup = (Giftgroup) giftData;
                giftgroupRepository.save(giftgroup.id, giftgroup);
            } else if (giftData instanceof Gift) {
                Gift gift = (Gift) giftData;
                giftRepository.save(gift.codepoint, gift);
            }
        }
        log.info("End   GiftDataImportRunner服务启动执行，执行Gift数据导入");
    }
}
