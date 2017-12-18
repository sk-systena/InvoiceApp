package invoice.dao;

import java.util.List;

import invoice.systena.bean.TestBean;



public interface TestDao {

  List<TestBean> selectAll();

}