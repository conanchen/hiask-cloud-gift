package org.ditto.gift.data;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.ditto.gift.model.Gift;
import org.ditto.gift.model.Giftgroup;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@Slf4j
public class GiftTextConverter {
    final static Gson gson = new Gson();
    final static Pattern groupPattern = Pattern.compile("^# group: (.*)");
    final static Pattern subgroupPattern = Pattern.compile("^# subgroup: (.*)");
    final static Pattern codepointPattern = Pattern.compile("^(.*);.*qualified.*#(.*)");

    public static void main(String args[]) {

        processGiftText(GiftText.giftLines);

    }

    public static ArrayList<Object> processGiftText(String[] lines) {
        ArrayList<Object> result = new ArrayList<>();
        int groupIdNo = 0, subgroupIdNo = 0, sequence = 0;
        String groupId = String.format("g%d", groupIdNo++);
        String subgroupId = String.format("sg%d", subgroupIdNo++);
        for (int i = 0; i < lines.length; i++) {

            Matcher groupmatcher = groupPattern.matcher(lines[i]);
            Matcher subgroupmatcher = subgroupPattern.matcher(lines[i]);
            Matcher codepointmatcher = codepointPattern.matcher(lines[i]);

            if (groupmatcher.find()) {
                groupId = String.format("g%d", groupIdNo++);
                String groupName = groupmatcher.group(1);
                Giftgroup giftgroup = Giftgroup.builder()
                        .setLine(String.format("%d-%d", sequence++, i))
                        .setGroupId(groupId)
                        .setName(groupName)
                        .setSequence(sequence)
                        .setLastUpdated(System.currentTimeMillis())
                        .setActive(true)
                        .build();
                log.info(gson.toJson(giftgroup));
                result.add(giftgroup);
            } else if (subgroupmatcher.find()) {
                subgroupId = String.format("sg%d", subgroupIdNo++);
                String subgroupName = subgroupmatcher.group(1);
                Giftgroup giftsubgroup = Giftgroup.builder()
                        .setLine(String.format("%d-%d", sequence++, i))
                        .setGroupId(groupId)
                        .setSubgroupId(subgroupId)
                        .setName(subgroupName)
                        .setSequence(sequence)
                        .setLastUpdated(System.currentTimeMillis())
                        .setActive(true)
                        .build();
                log.info(gson.toJson(giftsubgroup));
                result.add(giftsubgroup);
            } else if (codepointmatcher.find()) {
                String codepoint = codepointmatcher.group(1).trim();
                String codepointu16 = codepoint2utf16(codepoint) + "";
                String name = codepointmatcher.group(2).trim();
                Gift gift = Gift.builder()
                        .setLine(String.format("%d-%d", sequence++, i))
                        .setGroupId(groupId)
                        .setSubgroupId(subgroupId)
                        .setCodepoint(codepoint)
                        .setCodepointu16(codepointu16)
                        .setName(name)
                        .setSequence(sequence)
                        .setLastUpdated(System.currentTimeMillis())
                        .setActive(true)
                        .build();
                log.info(gson.toJson(gift));
                result.add(gift);
            }
        }
        return result;
    }


    public static String codepoint2utf16(String codePointString) {
        String[] codepoints = codePointString.split("[\\W]+");
        int[] codepointInts = new int[codepoints.length];
        for (int i = 0; i < codepoints.length; i++) {
            codepointInts[i] = Integer.valueOf(codepoints[i], 16);
        }
        String hexes = new String(codepointInts, 0, codepointInts.length);
        return hexes;
    }


}