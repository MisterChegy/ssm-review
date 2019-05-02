import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseDAO <E>{
	public int add (E e);
	public int deleteById(Integer id);
	public int update(E e);
	public List<E> queryAll();
	public E queryById(Integer id);
	public int deleteMore(int [] ids);
	public int addMore(List<E> es);
	
}
