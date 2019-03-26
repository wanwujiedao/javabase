package com.dao.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全问题
 *
 * @author 阿导
 * @CopyRight 萬物皆導
 * @Created 2019年03月25日 16:55:00
 */
public class ThreadSafe {

    /**
     * 重入锁锁定当前执行的对象，只是测试，正式环境慎用，防止导致死锁的情况
     */
    private static Lock lock = new ReentrantLock();

    /**
     * 业务实现，只是示例，实际写代码应该单独写一个类去实现接口，建议平时开发注意依赖倒置原则
     */
    private StudentService studentService = new StudentService() {
        @Override
        public StudentDO queryStudent(Long stuId) {
            System.out.println("查询学生信息:" + stuId);
            return new StudentDO();
        }

        @Override
        public int updateStudent(StudentDO student) {
            System.out.println("更新学生信息" + student.getId());

            return 0;
        }

        @Override
        public void printStudent(StudentDO student) {
            System.out.println("打印学生信息" + student.getId());

        }
    };

    /**
     * 打印学生成绩适配器
     */
    private StudentServiceAdapter printAdapter = new PrintAdapter();
    /**
     * 更新学生成绩适配器
     */
    private StudentServiceAdapter updateAdapter = new UpdateAdapter();
    /**
     * 查询学生信息适配器
     */
    private StudentServiceAdapter queryAdapter = new QueryAdapter();

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadSafe main = new ThreadSafe();
        StudentDO studentDO = new StudentDO();
        Long id = 0L;
        studentDO.setId(id);
        // 根据适配器选择不同的操作
        Thread threadA = getThread(main.studentService, studentDO, main.queryAdapter);
        Thread threadB = getThread(main.studentService, studentDO, main.updateAdapter);
        Thread threadC = getThread(main.studentService, studentDO, main.printAdapter);


        // 主线程检测线程状态
        while (true) {
            threadA=keepThreadLive(threadA,main.studentService,studentDO,main.queryAdapter);
            threadB=keepThreadLive(threadB,main.studentService,studentDO,main.updateAdapter);
            threadC=keepThreadLive(threadC,main.studentService,studentDO,main.printAdapter);
        }
    }

    /**
     * 确保线程是活的
     *
     * @author 阿导
     * @time 2019/3/26 9:49
     * @CopyRight 万物皆导
     * @param thread
     * @param studentService
     * @param studentDO
     * @param serviceAdapter
     * @return
     */
    private static Thread keepThreadLive(Thread thread,StudentService studentService,StudentDO studentDO,StudentServiceAdapter serviceAdapter){
        if (thread == null || !thread.isAlive() || thread.isInterrupted()) {
            (thread = getThread(studentService, studentDO,serviceAdapter)).start();
        }
        return thread;
    }

    /**
     * 业务处理适配接口层
     *
     * @author 阿导
     * @CopyRight 萬物皆導
     * @created 2019/3/25 17:08
     * @Modified_By 阿导 2019/3/25 17:08
     */
    interface StudentServiceAdapter {
        /**
         * 适配处理
         *
         * @param studentService
         * @param studentDO
         * @return
         * @author 阿导
         * @time 2019/3/25 17:10
         * @CopyRight 萬物皆導
         */
        void doAdapter(StudentService studentService, StudentDO studentDO);
    }

    class PrintAdapter implements StudentServiceAdapter {

        /**
         * 适配处理：打印學生成績
         *
         * @param studentService
         * @param studentDO
         * @return
         * @author 阿导
         * @time 2019/3/25 17:10
         * @CopyRight 萬物皆導
         */
        @Override
        public void doAdapter(StudentService studentService, StudentDO studentDO) {
            studentService.printStudent(studentDO);
        }
    }

    class UpdateAdapter implements StudentServiceAdapter {

        /**
         * 适配处理：更新學生信息
         *
         * @param studentService
         * @param studentDO
         * @return
         * @author 阿导
         * @time 2019/3/25 17:10
         * @CopyRight 萬物皆導
         */
        @Override
        public void doAdapter(StudentService studentService, StudentDO studentDO) {
            studentService.updateStudent(studentDO);
        }
    }

    class QueryAdapter implements StudentServiceAdapter {

        /**
         * 适配处理：查詢學生信息
         *
         * @param studentService
         * @param studentDO
         * @return
         * @author 阿导
         * @time 2019/3/25 17:10
         * @CopyRight 萬物皆導
         */
        @Override
        public void doAdapter(StudentService studentService, StudentDO studentDO) {
            studentService.queryStudent(studentDO.getId());
        }
    }


    /**
     * 获取线程
     *
     * @param studentService
     * @param studentDO
     * @param serviceAdapter
     * @return
     * @author 阿导
     * @time 2019/3/25 17:03
     * @CopyRight 萬物皆導
     */
    private static Thread getThread(StudentService studentService, StudentDO studentDO, StudentServiceAdapter serviceAdapter) {
        return new Thread(() -> {
            try {
                lock.lock();
                // 模拟业务处理
                Thread.sleep(50L);
                studentDO.setId(studentDO.getId() + 1L);
                // 根据适配器去选择不同的操作
                serviceAdapter.doAdapter(studentService, studentDO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        );
    }
}


/**
 * 学生操作业务接口层
 *
 * @author 阿导
 * @CopyRight 萬物皆導
 * @created 2019/3/25 16:56
 * @Modified_By 阿导 2019/3/25 16:56
 */

interface StudentService {
    /**
     * 查询学生成绩
     *
     * @param stuId 学生ID，由cmd控制台输入
     * @return 学生成绩模型
     **/

    StudentDO queryStudent(Long stuId);

    /**
     * 修改学生成绩
     *
     * @param student 学生模型，由cmd控制台输入
     * @return 修改影响记录数
     **/

    int updateStudent(StudentDO student);

    /**
     * 打印学生成绩
     *
     * @param student 学生模型
     **/

    void printStudent(StudentDO student);
}

/**
 * 学生实体
 *
 * @author 阿导
 * @CopyRight 萬物皆導
 * @created 2019/3/25 16:56
 * @Modified_By 阿导 2019/3/25 16:56
 */

class StudentDO {
    /**
     *
     */
    private Long id;

    private Integer score1;
    private Integer score2;
    private Integer score3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }
}