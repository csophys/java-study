package nlp;

import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;

import java.util.List;
import java.util.Set;

public class DemoTextClustering {
    static String text="这，有问题\n" +
            "人工服务\n" +
            "有人在吗\n" +
            "餐未到却显示已送达\n" +
            "\"为什么这么久还没有骑手接单\n" +
            "\"\n" +
            "菜品送错了\n" +
            "为何没骑手接单\n" +
            "我10点50订的餐预计送达时间11点46，饭凉了我是该找店家还是骑手\n" +
            "转人工\n" +
            "商家已接单，但是刚刚骑手来电，说商家机器坏了，出不了餐，要等很久\n" +
            "在吗\n" +
            "为何没骑手接单\n" +
            "人工服务\n" +
            "\n" +
            "怎么还没到呢\n" +
            "你好\n" +
            "你好\n" +
            "人工服务\n" +
            "人工\n" +
            "在\n" +
            "\n" +
            "餐显示送达，但还没收到\n" +
            "菜品质量问题\n" +
            "为何没骑手接单\n" +
            "人工\n" +
            "支付宝\n" +
            "人工\n" +
            "吃出了虫子和鸡蛋皮\n" +
            "昨天的订单，至今未收到餐\n" +
            "人工\n" +
            "开票失败\n" +
            "网络异常无法提单怎么回事\n" +
            "人工\n" +
            "在吗\n" +
            "人工\n" +
            "为何没骑手接单\n" +
            "\"您好\n" +
            "\"\n" +
            "为何没骑手接单\n" +
            "商家\n" +
            "换手机号码后，为什么红包找不到了\n" +
            "紧张就别开\n" +
            "珍珠硬硬的没有口感\n" +
            "无法支付\n" +
            "餐未到却显示已送达\n" +
            "追加备注联系方式13559706383\n" +
            "菜品质量问题\n" +
            "修改配送地址\n" +
            "餐未到却显示已送达\n" +
            "您好\n" +
            "美团真是让我太失望了\n" +
            "菜品口味不佳\n" +
            "我的订单还没有骑手送\n" +
            "我不是预订了12点送达吗\n" +
            "在吗\n" +
            "订单超出配送范围了吗\n" +
            "找一堆借口\n" +
            "投诉商家、骑手\n" +
            "你好，我昨天买的会员没了\n" +
            "现在是没有骑手接单\n" +
            "人工服务\n" +
            "已经超出准时宝二十分钟，这个该怎么算呀？\n" +
            "5元红包升级8元红包  点错了商家  这个能退吗   饿了么是支持退的\n" +
            "人工服务\n" +
            "为何没骑手接单\n" +
            "无人接单\n" +
            "在吗\n" +
            "请回电15942092518\n" +
            "马上超时了还没送到\n" +
            "为何没骑手接单\n" +
            "取消所有投诉，\n" +
            "我的餐现在怎么办\n" +
            "评价未正常显示\n" +
            "有人吗\n" +
            "工人服务\n" +
            "转人工客服\n" +
            "菜品少送\n" +
            "送餐离规定时晚了10分钟\n" +
            "人工\n" +
            "人工客服\n" +
            "菜品少送\n" +
            "红包无法使用\n" +
            "修改配送地址\n" +
            "您好，我没收到发票，联系不到店家\n" +
            "转人工\n" +
            "等的时间够久了\n" +
            "如何联系商家\n" +
            "请问我的鸭蛋呢\n" +
            "\n" +
            "都一个小时了，我该退款还是怎样\n" +
            "退款申请被拒绝\n" +
            "你好\n" +
            "退款取消后能否再次申请\n" +
            "人工服务\n" +
            "查询订单送达时间\n" +
            "如何联系商家\n" +
            "你好帮我看看有没有外卖员送餐\n" +
            "未收餐显示已送达\n" +
            "新用户立减活动\n" +
            "订单超时";
    public static void main(String[] args) {
        String[] textList = DemoTextClustering.text.split("\n");
        System.out.println("文本的个数是："+textList.length);
        ClusterAnalyzer<String> analyzer = new ClusterAnalyzer<String>();
        for (int i = 0; i < textList.length; i++) {
            analyzer.addDocument(textList[i], textList[i]);
        }

        List<Set<String>> x = analyzer.repeatedBisection(1.0);
        for (Set<String> strings : x) {
            System.out.println(strings.size()+"{"+strings+"}");
        }
        System.out.println(x);
    }
}