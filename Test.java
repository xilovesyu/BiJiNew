package com.xi;

import java.util.ArrayList;

/**test my software
 * Created by xijiaxiang on 2016/2/16.
 */
public class Test {
    public static void main(String[] args) {
       /// Card card=new Card(Card.MEIHUA,1);
        //System.out.println(card.printCard());
        CardHandler cardHandler=new CardHandler();
        Card[] cards=cardHandler.InitCards();
        ///////////////////////////
        Person[] p=new Person[6];
        for (int i=0;i<p.length;i++){
            p[i]=new Person("李"+(i+1)+"狗",100);
        }
        ///////////////////////////
        cardHandler.XiCards();
        cardHandler.FaCards(p);
        for (Person m:p) {
            m.printCard();
        }

        ///列出第一个人的牌的所有可能的组合
        ArrayList<OneCards[]> getAllCount=cardHandler.ListAllCount(p[0]);
        /*for (OneCards[] temp:getAllCount) {
            System.out.println(temp[0].getJifen()+","+temp[1].getJifen()+","+temp[2].getJifen());
        }*/
        int maxFirstOneCards=0;
        int indexOfmaxFirst=0;
        for (int i = 0; i < getAllCount.size(); i++) {
            if(getAllCount.get(i)[0].getJifen()>maxFirstOneCards){
                maxFirstOneCards=getAllCount.get(i)[0].getJifen();
                indexOfmaxFirst=i;
            }
        }
        Card[] firstcards=getAllCount.get(indexOfmaxFirst)[0].getOnecards();
        System.out.println("第一组最大积分为"+maxFirstOneCards+","+firstcards[0].printCard()+firstcards[1].printCard()+firstcards[2].printCard());
    }
}
