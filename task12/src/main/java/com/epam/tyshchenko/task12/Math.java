package com.epam.tyshchenko.task12;

/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
public class Math {

    /**
     * Sum int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public int sum(int a, int b){
        return a+b;
    }

    /**
     * Sub int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public int sub(int a, int b){
        return a-b;
    }

    /**
     * Mul int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public int mul(int a, int b){
        return a*b;
    }

    /**
     * Div int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     * @throws ArithmeticException the arithmetic exception
     */
    public int div(int a, int b) throws ArithmeticException{
        return a/b;
    }

}
