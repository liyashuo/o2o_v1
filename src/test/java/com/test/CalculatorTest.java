package com.test;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static Calculator cal = new Calculator();

    @BeforeClass
    //在测试类被调用之前执行
    public static void setUpBeforeClass() throws Exception{
        System.out.println("@BeforeClass");
    }
    @AfterClass
    //在测试类被调用结束退出之前执行
    public static void tearDownAfterClass() throws Exception{
        System.out.println("@AfterClass");
    }

    @Before
    //在每个@Test调用之前执行
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    //在每个@Test调用之后执行
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @Test
    public void testAdd() {
        cal.add(2,2);
        assertEquals(4,cal.getResult());
        //fail("Not yet implemented");
    }

    @Test
    public void testSubtract() {
        cal.subtract(4,2);
        assertEquals(2,cal.getResult());
        //fail("Not yet implemented");
    }

    @Ignore
    //暂不执行的测试用例，会被JUnit4忽略执行
    public void testMultiply() {
        fail("Not yet implemented");
    }

    @Test(timeout = 2000)
    public void testDivide() {
        for(;;);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        cal.divide(4,0);
    }


}
