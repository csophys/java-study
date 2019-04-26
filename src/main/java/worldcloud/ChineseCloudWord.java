package worldcloud;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.image.AngleGenerator;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChineseCloudWord {
    static String text="CONSULT_DESCRIPTION\n" +
            "能不能直接退款到账户啊\n" +
            "我领的一个会员红包，领之前在配送范围内，现在领了在配送范围外了，这是怎么回事？能不能给我退了\n" +
            "会员红包使用规则\n" +
            "人工\n" +
            "通知商家继续做，正常配送\n" +
            "你好\n" +
            "更换手机号，红包用不了\n" +
            "您好 我都没有收到东西\n" +
            "准时保赔付\n" +
            "没有准时达\n" +
            "购买的会员可以取消吗\n" +
            "你好\n" +
            "投诉结果\n" +
            "人工\n" +
            "你好\n" +
            "我的外卖写错手机号码了\n" +
            "。\n" +
            "我怎么把免密支付取消？\n" +
            "怎么能快速退款啊？\n" +
            "恩\n" +
            "修改配送地址\n" +
            "你好，订单送来了，但是少了一份薯霸王\n" +
            "人工\n" +
            "我要追加备注\n" +
            "十二点十五送达\n" +
            "你好 我昨天买了会员加量包的今天红包就全没了？\n" +
            "新版美团没有了生活费？\n" +
            "你好\n" +
            "用户转接成功\n" +
            "是什么情况\n" +
            "您好\n" +
            "没人接吗\n" +
            "订单为什么取消\n" +
            "出发了吗？\n" +
            "\"人工\n" +
            "\"\n" +
            "我送餐地址填错了\n" +
            "为什么我昨天买的会员今天就过期了\n" +
            "开发票\n" +
            "帮我尽快烧好了\n" +
            "11点50\n" +
            " 支付方式没有\n" +
            "申请退款被拒绝\n" +
            "你好我想把东西放美团去怎么做\n" +
            "为何没骑手接单\n" +
            "用餐后导致身体不适\n" +
            "怎么办\n" +
            "一杯可乐不要冰\n" +
            "商家说是你们的问题\n" +
            "人工客服\n" +
            "发票金额比实际支付金额少6元\n" +
            "我的美团为什么不能支付宝支付？\n" +
            "棒骨换成脊骨\n" +
            "转人工\n" +
            "订单为什么取消\n" +
            "为什么我买的会员代金券全没了\n" +
            "3666 5822 1877 4765 3\n" +
            "我有一个退款到现在没到账\n" +
            "我昨天中午定餐，有两次都没成功，退单了\n" +
            "人工\n" +
            "\"你好\n" +
            "\"\n" +
            "你好\n" +
            "原来的手机号码不用了\n" +
            "投诉商家\n" +
            "忘了备注微微的辣味就可以\n" +
            "为何没骑手接单\n" +
            "投诉\n" +
            "民族送餐到寝吗\n" +
            "<img src=\"\"http://p0.meituan.net/csc/e0885aa6-6a9b-4768-b069-e4b96930ceda.png\"\" class=\"\"upload-img\"\" />\n" +
            "为什么没有催单功能\n" +
            "没有支付宝支付选项\n" +
            "亲，我是新用户吗？\n" +
            "发票\n" +
            "可以更改送的时间\n" +
            "这个订单\n" +
            "为什么没有送到就显示送达了\n" +
            "餐未到却显示已送达\n" +
            "想成为众包骑手。报名显示成功怎么没有下一步\n" +
            "你好\n" +
            "注销不了\n" +
            "我的外卖没有骑手接单 已经超过了到达时间 商家不给退款 让我找美团\n" +
            "取消退款后再次申请部分退款\n" +
            "会员红包咋叠加\n" +
            "人工\n" +
            "我的帐号就是我的手机号 也是我的收餐号码为什么优惠券不能使用呢\n" +
            "退款申请被拒绝\n" +
            "为何没骑手接单\n" +
            "商家自己配送已经一个半小时没送过来了\n" +
            "我六点多就定了\n" +
            "你好，我想修改一下手機號，但是原來的手機號被註銷了\n" +
            "亲刚买的红包发现截止到今天，能不能退呢\n" +
            "人工\n" +
            "我是甘肃的，我想帮朋友定外卖，他在湖南，怎么定\n" +
            "\"有人吗\n" +
            "\"\n" +
            "人工服务\n" +
            "转人工客服\n" +
            "商家不接单\n" +
            "人工\n" +
            "在吗\n" +
            "昨天说给的卷呢\n" +
            "准时宝的退款怎么没有到账？\n" +
            "怎能这样\n" +
            "我要开发票\n" +
            "你好，我的订单支付宝付款成功了\n" +
            "，\n" +
            "昨天的订单预计12点9分送到，但12点20没到，我要出去开会申请退款，商家说已经做了不退。最后13点小哥才打电话说送到，可我已经出去开会了，东西没见到，款也不退？\n" +
            "您好 我要的金桔茶但送的是奶茶\n" +
            "修改电话\n" +
            "您好，请调出我的支付宝付款选项\n" +
            "订的面居然还超时，这面还能吃吗\n" +
            "在吗\n" +
            "为什么不让我买会员\n" +
            "我助力红包没有到账\n" +
            "用户转接成功\n" +
            "修改取餐电话\n" +
            "不要小票，如果有人查，可以出去拿\n" +
            "无骑手接单\n" +
            "？\n" +
            "如何取消催单\n" +
            "你好\n" +
            "商家没有开门，我要取消订单\n" +
            "我想修改一下送达时间\n" +
            "如何申请退款\n" +
            "能不能不要这么快送\n" +
            "呵呵哒\n" +
            "已经过了配送时间怎么还没到。骑手从龙城花园这里经过怎么没配送？\n" +
            "人工客服\n" +
            "好的\n" +
            "\".\n" +
            "\"\n" +
            "希望店家快些，快饿死了\n" +
            "    你好，我想改下我这个地址\n" +
            "在吗\n" +
            "请携带2人餐具\n" +
            "用户转接成功\n" +
            "退款申请被拒绝\n" +
            "有会员年费吗\n" +
            "都超时了怎么还离我这么远啊\n" +
            "人工\n" +
            "什么情况呀\n" +
            "ninh\n" +
            "为何没骑手接单\n" +
            "我要更换绑定得手机号更换不了无法订餐\n" +
            "如何申请退款\n" +
            "红包无法使用\n" +
            "求助途径\n" +
            "你好\n" +
            "半小时了，没人送\n" +
            "\"人工\n" +
            "\"\n" +
            "人工客服\n" +
            "邀新好友赢红包\n" +
            "你好\n" +
            "\"您好\n" +
            "\"\n" +
            "昨天客服说一个小时内补偿一个10元的红包给我 到现在都没有的？\n" +
            "在么\n" +
            " 在吗\n" +
            "骑手说车被交警扣了。让别的同事帮忙送。但我看不到进程\n" +
            "在吗\n" +
            "人工客服\n" +
            "\"打开每天看见 周黑鸭 满69减30 在哪进入这个活动\n" +
            "\"\n" +
            "我怎么给你发截图啊\n" +
            "注销后可重新注册吗\n" +
            "[调皮]\n" +
            "zai\n" +
            "人工\n" +
            "我搜不到孔明村麻辣香锅宁大店，旁边同学就可以搜到点外卖\n" +
            "叫他快点了\n" +
            "你好\n" +
            "我想开发票或者收据\n" +
            "有人吗\n" +
            "我的卡刚办的  显示别人的名字 是不是你们这没有清空他的信息？\n" +
            "查询订单送达时间\n" +
            "配送慢/超时\n" +
            "调出我的支付宝付款选项\n" +
            "亲";
    public static void main(String[] args) {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        Collection<String> stopWorld = new ArrayList<>();
        stopWorld.add("人工");
        stopWorld.add("转人工");
        stopWorld.add("转人工客服");
        stopWorld.add("人工服务");
        stopWorld.add("人工客服");
        stopWorld.add("你好");
        stopWorld.add("在吗");
        stopWorld.add("您好");
        stopWorld.add("有人吗");
        stopWorld.add("有人在吗");
        frequencyAnalyzer.setStopWords(stopWorld);
        frequencyAnalyzer.setMinWordLength(3);
        String[] textList = text.split("\n");
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(Arrays.asList(textList));
        final Dimension dimension = new Dimension(1000, 1000);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new RectangleBackground(dimension));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5), new Color(0x806EF5)));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        //调整文字放置的方向。
        wordCloud.setAngleGenerator(new AngleGenerator(0,0,2));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("kumo-core/1.png");
    }
}

