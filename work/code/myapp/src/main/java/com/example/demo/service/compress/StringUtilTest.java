package com.example.demo.service.compress;

import java.io.IOException;

/**
 * @author gaonan1
 * @date 2021/4/16 17:01
 **/
public class StringUtilTest {

    public static void main(String[] args) throws IOException {
        String s = "{\"personalRecommendCard\":[{\"templateId\":3,\"templateType\":\"card\",\"templateContent\":{\"title\":\"借钱\",\"desc\":\"新浪官方,安全合规\",\"amount\":200000,\"amountDesc\":\"最高额度(元)\",\"buttonText\":\"去借钱\",\"landingPageUrl\":\"https://apps.weibo.com/linkcard/1042125:home\"}},{\"templateId\":4,\"templateType\":\"card\",\"templateContent\":{\"title\":\"信用卡\",\"desc\":\"申请简单,快速发卡\",\"amount\":50000,\"amountDesc\":\"最高额度(元)\",\"buttonText\":\"去申请\",\"landingPageUrl\":\"https://apps.weibo.com/linkcard/2365067991:5EE21754.do\"}}],\"fixedEntranceIconOne\":{\"templateType\":\"walletIconId\",\"templateContent\":{\"walletIconId\":22}},\"fixedEntranceIconTwo\":{\"templateType\":\"walletIconId\",\"templateContent\":{\"walletIconId\":29}}}";
        // String s = "+HNkhyrivPnRVFjdeKO3KXliG3UuTFJ53uwpraKi0UkYsUsK+UDFzjiF1EXfEzjTcRagePoKFoyjxNO4hdno9CGn/WvC8l1lCXxx9IJxW+pByBT3k6EAqKiGnxkEWyaKRbtQfb8eOmCNaEGGjbOgzBcTAp52kELxrU+rLvjAsfNpAtaX9GHi/jDVBKM4VTC0VpuOfxhPMQmnJsnQHJUAk9K18nv5CP3wCTtrUmqDeWteym8v8kuaz+VqMmqGEavl5HJn7XcHvwrtDKGQFYQhfTPov+WON5miGK3Our3NZIofA7kWg9EKURVhWC9APdBQvdLgx/pkQ4baWrLe8Zu94hL7lpuwjPsiEBHTmEKxhx2f9BEs2BqwHfP5MFwafT/5huwXu50KEvkkLal7+am9dwMzSD9Jo63XFAMpGsEViCZk2qrFGiEY/MElN84pkJTzrVwHPUujRyRT0tmvQWSH6js2E1JsOqV78xuKthHctNUzAEkjH/Ie7RdQ1rt9LirYFkh9QaK23PuPYizYS0F1XkxgTDTIqK0lYGM9pR1gyPf81ESjLG4N+bENwJKEx3QZnvLwENuNKr0e8zEa+MJzZfI3ziZPVHrh/oXShBsQaA+FNa2VWCzJaY6ChnPg1H3wy1IrhO9cEynNNDRY3TMZRh3dIpi7BBuVFuDCKl3jwQPmW3i/dIqqpV4vuyKFPkpAEHqLPeh+FRJSBlnEEDV0m2XHiANv68V7g+ECE6m25DUrZp6gEOext15D48x9dx74vBS3KQbz8AgyrM7fuaI1ypxilocIYAuGl9q3NJr7LuTBHSnq6EHQEffh19xTM84oHKfEK43PC4M1H5+Qkjp43ItId84ZZejr6+SxjNgxPq7XX6yLipiFCo9DHdXEOh3RRn8Ni8RemIvS6EgWWYaZG4mJeCsscMD1HjgZkHVGcAsDNLDcdShqQ57EKobTybpGlgYx1PDgfVl65atBpYj43g==";
        System.out.println(s.length());
        String compress = StringUtil.compress(s, "utf-8");
        System.out.println(compress.length());
        String b = StringUtil.uncompress(compress, "utf-8");
    }
}
