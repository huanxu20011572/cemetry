package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.entity.Dept;
import com.topsuntech.gUnit.gEU_util.entity.Region;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

public class BzhhParentDeptNameByDeptIdTag extends KeyValueTag {

	@Override
	public Object getValue(Object arg0, Map arg1) {
		if (arg0 == null || "".equals(arg0.toString())) {
			return null;
		}
		try {
				
				String deptShowName="";
				
				if(arg0.toString()!=null&&!arg0.toString().equals("")){
					
						Long userId=Long.parseLong(arg0.toString());
						Long deptId=null;
						Dept dept = Dicts.getDeptById(userId);
						Long levelid=dept.getLevelid();
						Long region=dept.getRegionid();
						deptId=dept.getId();
					
						String regionName="";
						String lastName="";
						Dept dept1=new Dept();
						//ѭ��ȡ��������
						while(true){
							dept1=Dicts.getDeptById(deptId);
							
								if(dept1==null||region.longValue()!=dept1.getRegionid().longValue()){
									break;
								}else{
									Region nowRegion=Dicts.getRegionById(dept1.getRegionid());
									if(nowRegion!=null){
										String nowRegionName=nowRegion.getName();
										
										if(dept1.getParentId().intValue()==0){
											break;
										}else{
											if(!lastName.equals(nowRegionName)&&!lastName.equals("")){
												regionName=regionName+nowRegionName;
											}else if(lastName.equals(nowRegionName)){
												if(!dept1.getName().trim().equals(nowRegionName.trim())){
													regionName=regionName+dept1.getName();
												}else{
													regionName=nowRegionName+regionName;
												}
											}
											
											lastName=nowRegionName;
											deptId=dept1.getParentId();
										}
									}else{
										break;
									}
								}
						}
						//�м��û�������ʾ:��ʽ=�ϼ�����+��������
						if(levelid.longValue()==1){
							//�м���߼��û�ֱ����ʾ���ڲ��ţ������ϼ�����+��������
							if(regionName.equals("")){
								deptShowName=dept.getName();
							}else{
								deptShowName=regionName+dept.getName();
							}
						}else if(levelid.longValue()==2){//�����û�������ʾ����ʽ=������������+�ϼ���������+������������
								//���ر���ֱ����ʾ�������ţ�����������������+�ϼ���������+������������
								if(regionName.equals("")){
									deptShowName=dept.getName();
								}else{
									deptShowName=regionName+dept.getName();
								}
						}else if(levelid.longValue()==3){//�ֵ��û�������ʾ����ʽ=������������+�ֵ�����+�ϼ���������+������������
							String parentRegionName=Dicts.getRegionById(dept1.getRegionid()).getName();
							//�ֵ�����ֱ����ʾ����+�������ƣ�����������������+�ֵ�����+�ϼ���������+������������
							if(regionName.trim().equals(dept.getName().trim())||regionName.equals("")){
								deptShowName=parentRegionName+dept.getName();
							}else{
								deptShowName=parentRegionName+regionName+dept.getName();
							}
						}
				     }
				
			
				return deptShowName;
		} catch (TSDBException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		 }
		return null;
	}
	


}
