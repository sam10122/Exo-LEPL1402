import org.junit.Assert;
import org.junit.Test;

public class NewsPublisherTest {
    String receivedNews, receivedNews2;
    int receivedCount;

    // Test: Subscriber should receive news for the subscribed topics.
    @Test
    public void testSubscription() {
        NewsPublisher pub=new NewsPublisher();
        NewsPublisher.Subscriber sub=(String news) -> receivedNews=news;

        pub.subscribe(sub, 0);
        pub.subscribe(sub, 1);

        receivedNews=null;
        pub.publishNews(0,"News0");
        Assert.assertEquals("News0",receivedNews);

        receivedNews=null;
        pub.publishNews(1,"News1");
        Assert.assertEquals("News1",receivedNews);

        receivedNews=null;
        pub.publishNews(2,"News3");
        Assert.assertNull(receivedNews);   // not subscribed to topic 2
    }

    // Test: Nothing should happen if subscriber subscribes twice to the same
    // topic
    @Test
    public void testSameTopic() {
        NewsPublisher pub=new NewsPublisher();
        NewsPublisher.Subscriber sub=(String news) -> receivedCount++;

        pub.subscribe(sub, 0);
        pub.subscribe(sub, 0);

        receivedCount=0;
        pub.publishNews(0,"News0");
        Assert.assertEquals(1, receivedCount);
    }

    // Test: Multiple subscribers can subscribe to the same topic
    @Test
    public void testMultipleSubscribers() {
        NewsPublisher pub=new NewsPublisher();
        NewsPublisher.Subscriber sub1=(String news) -> receivedNews=news;
        NewsPublisher.Subscriber sub2=(String news) -> receivedNews2=news;

        pub.subscribe(sub1, 0);
        pub.subscribe(sub2, 0);

        receivedNews=null;
        receivedNews2=null;
        pub.publishNews(0, "News0");
        Assert.assertEquals("News0", receivedNews);
        Assert.assertEquals("News0", receivedNews2);
    }

    // Test: Unsubscribe to a topic
    @Test
    public void testUnsubscribe() {
        NewsPublisher pub=new NewsPublisher();
        NewsPublisher.Subscriber sub=(String news) -> receivedNews=news;

        pub.subscribe(sub, 0);
        pub.subscribe(sub, 1);
        pub.unsubscribe(sub, 0);

        receivedNews=null;
        pub.publishNews(0,"News0");
        Assert.assertNull(receivedNews);   // unsubscribed to topic 0

        receivedNews=null;
        pub.publishNews(1,"News1");
        Assert.assertEquals("News1",receivedNews); // still subscribed to topic 1
    }

    // Test: send news to ALL subscribers (topic -1)
    @Test
    public void testBroadcast() {
        NewsPublisher pub=new NewsPublisher();
        NewsPublisher.Subscriber sub1=(String news) -> { receivedCount++; receivedNews=news; };
        NewsPublisher.Subscriber sub2=(String news) -> { receivedCount++; receivedNews2=news; };

        pub.subscribe(sub1, 0);
        pub.subscribe(sub1, 1);
        pub.subscribe(sub2, 2);

        receivedCount=0;
        pub.publishNews(-1,"NewsForEverybody");

        // sub1 and sub2 received the news.
        // sub1 should not receive the news twice.
        Assert.assertEquals(2, receivedCount);
        Assert.assertEquals("NewsForEverybody",receivedNews);
        Assert.assertEquals("NewsForEverybody",receivedNews);
    }
}
