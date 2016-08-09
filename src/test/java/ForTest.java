/**
 * Created by tancw on 2016/8/1.
 */
public class ForTest {
	public static void main(String[] args) {
		for (int i = 6; i <= 20; i++) {
			String prize = "insert into `mk_vote_question` (id, `activeId`, `title`, `type`, `aswStime`, `aswEtime`, `pubTime`, `status`, `remark`) values(%d,'10046','中国队奥运会奖牌数','DAY_PRIZE','2016-08-%s 11:00:00','2016-08-%s 11:00:00','2016-08-%d 18:00:00','1','北京时间:8月%d日11:00—8月%d日11:00可预测,巴西时间:8月%d日的奖牌数')";
			String gold = "insert into `mk_vote_question` ( id,`activeId`, `title`, `type`, `aswStime`, `aswEtime`, `pubTime`, `status`, `remark`) values(%d,'10046','中国队奥运会金牌数','DAY_GOLD','2016-08-%s 11:00:00','2016-08-%s 11:00:00','2016-08-%s 18:00:00','1','北京时间:8月%d日11:00—8月%d日11:00可预测,巴西时间:8月%d日的金牌数')";
 			System.out.println(String.format(gold,10100+i ,i - 1, i, i +1, i - 1, i, i));
 			System.out.println(String.format(prize,10021+i ,i - 1, i, i+1, i - 1, i, i));

          String ogold ="insert  into `mk_vote_option`(`questionId`,`key`,`name`,`createTime`,`attr1`,`attr2`,`remark`) values (%d,NULL,'8月%d号(巴西时间)的金牌数','2016-07-21 11:21:31','2','500','单次竞猜:500元特权金,单次奖品:1000元特权金,开奖时间:8月%d日18:00（北京时间）')";
          String oprize ="insert  into `mk_vote_option`(`questionId`,`key`,`name`,`createTime`,`attr1`,`attr2`,`remark`) values (%d,NULL,'8月%d号(巴西时间)的奖牌数','2016-07-21 11:21:31','2','500','单次竞猜:500元特权金,单次奖品:1000元特权金,开奖时间:8月%d日18:00（北京时间）')";
//
            System.out.println(String.format(ogold, 10100+i,i,i+1));
            System.out.println(String.format(oprize,10021+i ,i,i+1));
        }
	}
}
