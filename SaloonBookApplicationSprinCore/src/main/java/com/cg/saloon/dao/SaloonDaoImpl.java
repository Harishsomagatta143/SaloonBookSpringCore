/*@Author hsomagat
*Project name:SaloonBookApplication
*  This is saloondaoimpl class where we can implement logic
*/

package com.cg.saloon.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.saloon.dto.Saloon;
import com.cg.saloon.util.DBUtil;
@Repository("saldao")
public class SaloonDaoImpl implements SaloonDao{

	
	public SaloonDaoImpl() {
		
	}

	public Saloon save(Saloon sal) {
		// TODO Auto-generated method stub
		DBUtil.sal.add(sal);
		 return sal;
	}

	public List<Saloon> findByName(String name) {
		List<Saloon> saloonList = new ArrayList<Saloon>();
		for (Saloon saloon :DBUtil.sal) {
			if(saloon.getName().equals(name))	{
				saloonList.add(saloon);	//saloon list added	
				return saloonList;}//return saloon list
			
	}
		
		return null;
	
	}
}


