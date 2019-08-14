package cassandra;

import java.math.BigDecimal;

public class TestToken {

    public static void main(String... args) {

//        long startToken = -9223372036854775808L;

        long startToken = Long.MIN_VALUE;

        long incrementer = 273101875948331383L;

        long endToken = startToken + incrementer;

        int iterator = 1;

//        System.out.println(Math.abs(startToken));
//        System.out.println(Math.abs(incrementer));
//        System.out.println(Math.abs(endToken));



//        while (endToken < 9223372036854775807L && ((Math.abs(startToken) > incrementer || startToken == Long.MIN_VALUE) && Math.abs(endToken) > incrementer)) {
            while (!(startToken > 0 && endToken < 0)) {


//                System.out.println("Iterator is " + iterator);

//            System.out.println("select count(0) from  costamendment  where token(costamendment_uuid) >= " + startToken + " and token(costamendment_uuid) < " + endToken + ";");
                System.out.println("select count(0) from  product_audit  where token(promotion_id, product_zone_uuid) >= " + startToken + " and token(promotion_id, product_zone_uuid) < " + endToken + ";");


                startToken = startToken + incrementer;
            endToken = startToken + incrementer;
            iterator += 1;

//            System.out.println(startToken);
//            System.out.println(incrementer);
//            System.out.println(endToken);
        }

        System.out.println("select count(0) from  product_audit  where token(promotion_id, product_zone_uuid) >= " + startToken + " and token(promotion_id, product_zone_uuid) < " + Long.MAX_VALUE + ";");
    }
}
