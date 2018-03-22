package com.shijc.ctci.Chapter03.Question3_7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 3.7猫狗收容所
 * 题目描述
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养
 * 所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早
 * 进入收容所的。给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所
 * 有事件。若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，
 * 负数代表猫；若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方
 * 式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操
 * 作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 * 测试样例：
 * [[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 *
 * @author shijiacheng
 * @date 2018/03/22
 */
public class Solution {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0]==1){
                if (ope[i][1]>0){
                    enqueue(new Dog(ope[i][1]));
                }else if (ope[i][1]<0){
                    enqueue(new Cat(ope[i][1]));
                }
            }else {
                if (ope[i][0] == 2){
                    if (ope[i][1]==0){
                        if (dogs.size()!=0||cats.size()!=0){
                            Animal any = dequeueAny();
                            if (any!=null){
                                result.add(any.name);
                            }

                        }
                    }else if (ope[i][1] == 1){
                        if (dogs.size()!=0){
                            Dog dog = dequeueDogs();
                            if (dog!=null){
                                result.add(dog.name);
                            }

                        }
                    }else if (ope[i][1] == -1){
                        if (cats.size()!=0){
                            Cat cat = dequeueCats();
                            if (cat!=null){
                                result.add(cat.name);
                            }

                        }
                    }
                }

            }
        }

        return result;
    }

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order=0;//收入的先后顺序
    public void enqueue(Animal a){
        a.setOrder(order);
        order++;
        if (a instanceof Dog){
            dogs.addLast((Dog)a);
        }else if (a instanceof Cat){
            cats.addLast((Cat)a);
        }
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }

    public Animal dequeueAny(){
        if (dogs.size() == 0){
            return dequeueCats();
        }else if (cats.size() == 0){
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOrderThan(cat)){
            return dequeueDogs();
        }else {
            return dequeueCats();
        }
    }


    class Animal{
        private int order;
        public int name;
        public Animal(int n){
            name = n;
        }
        public void setOrder(int ord){
            order = ord;
        }
        public int getOrder(){
            return order;
        }
        public boolean isOrderThan(Animal a){
            return this.order < a.getOrder();
        }
    }

    class Dog extends Animal{
        public Dog(int n){
            super(n);
        }
    }

    class Cat extends Animal{
        public Cat(int n){
            super(n);
        }
    }

    public static void main(String[] args){
        int[][] array = {{1,-2},{1,-5},{1,6},{1,6},{2,0},{1,-24},{1,4},{2,0},{1,-89},{2,1},{1,-90},{2,-1},{1,-86},{1,-3},{1,87},{2,-1},{2,0},{2,0},{2,1},{2,0},{1,-43},{2,1},{1,76},{1,-46},{1,70},{1,5},{1,11},{1,-11},{1,16},{2,0},{1,-61},{1,48},{2,1},{1,67},{1,-50},{1,72},{1,30},{1,-59},{1,95},{1,-92},{2,1}};
        Solution s = new Solution();
        ArrayList<Integer> list = s.asylum(array);

        if (list!=null){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+",");
            }
        }else {
            System.out.println("列表为空");
        }

    }


}
