package example.com.myproject.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import example.com.myproject.models.NewsModel;
import example.com.myproject.models.UserModel;

public class NewsService {

    public static List<NewsModel> createDummyData() {
        List<NewsModel> newslList = new ArrayList<>();
        List<String> tags1 = new ArrayList<>();
        tags1.add("mobile");
        tags1.add("web");
        tags1.add("phone");
        tags1.add("uxdesgin");
        List<UserModel> userList1 = new ArrayList<>();
        userList1.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList1.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList1.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList1.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList1.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        NewsModel news1 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "Updating the desgin for mobile app", new Date(), tags1, userList1);
        newslList.add(news1);

        List<String> tags2 = new ArrayList<>();
        tags2.add("mobile");
        tags2.add("web");
        tags2.add("phone");
        List<UserModel> userList2 = new ArrayList<>();
        userList2.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList2.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList2.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList2.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));

        NewsModel news2 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "VR Prototying Template Google Glass update", new Date(), tags1, userList2);
        newslList.add(news2);

        List<String> tags3 = new ArrayList<>();
        tags3.add("mobile");
        tags3.add("web");
        tags3.add("phone");
        List<UserModel> userList3= new ArrayList<>();
        userList3.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList3.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList3.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList3.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        NewsModel news3 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "Chrome desktop Material Design by Sebastien Gabriel", new Date(), tags1, userList3);
        newslList.add(news3);

        List<String> tags4= new ArrayList<>();
        tags4.add("mobile");
        tags4.add("web");
        tags4.add("phone");
        List<UserModel> userList4 = new ArrayList<>();
        userList4.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList4.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList4.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList4.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));

        NewsModel news4 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "Introducing Freehand - From Craft by InVision LABS", new Date(), tags1, userList4);
        newslList.add(news4);


        List<String> tags5= new ArrayList<>();
        tags5.add("mobile");
        tags5.add("web");
        tags5.add("phone");
        List<UserModel> userList5 = new ArrayList<>();
        userList5.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList5.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList5.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList5.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));

        NewsModel news5 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "Instagram 9 for iOS & Android", new Date(), tags1, userList4);
        newslList.add(news5);


        List<String> tags6 = new ArrayList<>();
        tags6.add("mobile");
        tags6.add("web");
        tags6.add("phone");
        List<UserModel> userList6 = new ArrayList<>();
        userList6.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList6.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList6.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));
        userList6.add(new UserModel("http://vanvat.net/hinhanh/anhto/14726avatar-co-gai-toc-dai-bong-benh-voi-lan-toc-roi.jpg", null));

        NewsModel news6 = new NewsModel("http://www.geekwire.com/wp-content/uploads/2016/02/uberriderlogo-e1454443856991-300x300.png",
                "Smart Sync Work without limition", new Date(), tags1, userList4);
        newslList.add(news6);
        return newslList;
    }




}
