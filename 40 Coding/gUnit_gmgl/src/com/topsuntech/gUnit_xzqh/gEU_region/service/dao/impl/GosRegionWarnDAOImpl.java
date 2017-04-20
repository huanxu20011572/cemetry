package com.topsuntech.gUnit_xzqh.gEU_region.service.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit.gEU_util.tools.Tools;
import com.topsuntech.gUnit_tjbz.gEU_apply.entity.ApDeadInfo;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionWarn;
import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.GosRegionWarnDAO;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionWarnQueryBean;

public class GosRegionWarnDAOImpl implements GosRegionWarnDAO {
	static SJBaseDAO dao = new SJBaseDAO();
	private static DBWrapper db = DBRegistry.getDefaultDBWrapper();

	public void addGosRegionWarn(GosRegionWarn gosRegionWarn)
			throws TSDBException {
		dao.addEntity(gosRegionWarn);
	}

	public void updateGosRegionWarn(GosRegionWarn gosRegionWarn)
			throws TSDBException {
		dao.updateEntity(gosRegionWarn);
	}

	public void deleteGosRegionWarn(GosRegionWarn gosRegionWarn)
			throws TSDBException {
		dao.deleteEntity(gosRegionWarn);
	}

	public GosRegionWarn getGosRegionWarnById(Long id) throws TSDBException {
		return (GosRegionWarn) dao.getEntity(GosRegionWarn.class, id);
	}

	public List queryGosRegionWarn(
			GosRegionWarnQueryBean gosRegionWarnQueryBean, Page page)
			throws TSDBException {
		StringBuffer hql = new StringBuffer();
		hql.append(" from GosRegionWarn t where 1 = 1");
		if (gosRegionWarnQueryBean != null) {
			if (gosRegionWarnQueryBean.getId() != null
					&& gosRegionWarnQueryBean.getId().longValue() != 0)
				hql.append(" and t.id = ").append(
						gosRegionWarnQueryBean.getId());
			if (gosRegionWarnQueryBean.getWarnName() != null
					&& !"".equals(gosRegionWarnQueryBean.getWarnName().trim()))
				hql.append(" and t.warnName like '%").append(
						gosRegionWarnQueryBean.getWarnName()).append("%'");
			if (gosRegionWarnQueryBean.getAdjustDate() != null)
				hql.append(" and t.adjustDate = to_date('").append(
						gosRegionWarnQueryBean.getAdjustDate()).append(
						"','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getEffectDate() != null)
				hql.append(" and t.effectDate = to_date('").append(
						gosRegionWarnQueryBean.getEffectDate()).append("','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getWarnContent() != null
					&& !"".equals(gosRegionWarnQueryBean.getWarnContent()
							.trim()))
				hql.append(" and t.warnContent like '%").append(
						gosRegionWarnQueryBean.getWarnContent()).append("%'");
			if (gosRegionWarnQueryBean.getWarnLevel() != null
					&& gosRegionWarnQueryBean.getWarnLevel().longValue() != 0)
				hql.append(" and t.warnLevel = ").append(
						gosRegionWarnQueryBean.getWarnLevel());
			if (gosRegionWarnQueryBean.getWarnRegion() != null
					&& gosRegionWarnQueryBean.getWarnRegion().longValue() != 0)
				hql.append(" and t.warnRegion = ").append(
						gosRegionWarnQueryBean.getWarnRegion());
			if (gosRegionWarnQueryBean.getCreateDate() != null)
				hql.append(" and t.createDate = to_date('").append(
						gosRegionWarnQueryBean.getCreateDate()).append(
						"','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getUseFlag() != null)
				hql.append(" and t.useFlag = ").append(
						gosRegionWarnQueryBean.getUseFlag());
			if (gosRegionWarnQueryBean.getCreateUserId() != null
					&& gosRegionWarnQueryBean.getCreateUserId().longValue() != 0)
				hql.append(" and t.createUserId = ").append(
						gosRegionWarnQueryBean.getCreateUserId());
			//四个查询条件
			//调整级别 adjustLevel
			if (gosRegionWarnQueryBean.getAdjustLevel() != null&& gosRegionWarnQueryBean.getAdjustLevel().longValue() != 0)
				hql.append(" and t.adjustLevel = ").append(gosRegionWarnQueryBean.getAdjustLevel());
			//调整类型 adjustType
			if (gosRegionWarnQueryBean.getAdjustType() != null&& gosRegionWarnQueryBean.getAdjustType().longValue() != 0)
				hql.append(" and t.adjustType = ").append(gosRegionWarnQueryBean.getAdjustType());
			//调整时间 adjustDate
			if(gosRegionWarnQueryBean.getStartAdjustDate() !=null && !"".equals(gosRegionWarnQueryBean.getStartAdjustDate())){	
				hql.append(" and t.adjustDate >= to_date('").append(gosRegionWarnQueryBean.getStartAdjustDate()).append("','yyyy-MM-dd')");
			}
			if(gosRegionWarnQueryBean.getEndAdjustDate() !=null && !"".equals(gosRegionWarnQueryBean.getEndAdjustDate())){
				Date date = null;
				try {
					date = Tools.getDateByStr(gosRegionWarnQueryBean.getEndAdjustDate().trim(), "yyyy-MM-dd");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				date.setDate(date.getDate()+1);
				String dateStr = toDateString(date);
				hql.append(" and t.adjustDate <= to_date('").append(dateStr).append("','yyyy-MM-dd')");
			}
			//生效时间：effectDate
			if(gosRegionWarnQueryBean.getStartEffectDate() !=null && !"".equals(gosRegionWarnQueryBean.getStartEffectDate())){	
				hql.append(" and t.effectDate >= to_date('").append(gosRegionWarnQueryBean.getStartEffectDate()).append("','yyyy-MM-dd')");
			}
			if(gosRegionWarnQueryBean.getEndEffectDate() !=null && !"".equals(gosRegionWarnQueryBean.getEndEffectDate())){
				hql.append(" and t.effectDate <= to_date('").append(gosRegionWarnQueryBean.getEndEffectDate()).append("','yyyy-MM-dd')");
			}
		}
		Logger.info(hql);
		if (page != null) {
			StringBuffer countHql = new StringBuffer("select count(*) ");
			return dao.query(hql.toString(), countHql.toString()+ hql.toString(), page);
		}
		return dao.queryList(hql.toString());
	}

	/**
	 * warn info 联合查询 
	 * 暂未使用
	 * @author zp
	 * */
	public List queryGosRegionWarnWithInfo(
			GosRegionWarnQueryBean gosRegionWarnQueryBean, Page page)
			throws TSDBException {
		StringBuffer hql = new StringBuffer();
		hql.append(" from GosRegionWarn t where 1 = 1");
		if (gosRegionWarnQueryBean != null) {
			if (gosRegionWarnQueryBean.getId() != null
					&& gosRegionWarnQueryBean.getId().longValue() != 0)
				hql.append(" and t.id = ").append(
						gosRegionWarnQueryBean.getId());
			if (gosRegionWarnQueryBean.getWarnName() != null
					&& !"".equals(gosRegionWarnQueryBean.getWarnName().trim()))
				hql.append(" and t.warnName like '%").append(
						gosRegionWarnQueryBean.getWarnName()).append("%'");
			if (gosRegionWarnQueryBean.getAdjustDate() != null)
				hql.append(" and t.adjustDate = to_date('").append(
						gosRegionWarnQueryBean.getAdjustDate()).append(
						"','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getEffectDate() != null)
				hql.append(" and t.effectDate = to_date('").append(
						gosRegionWarnQueryBean.getEffectDate()).append(
						"','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getWarnContent() != null
					&& !"".equals(gosRegionWarnQueryBean.getWarnContent()
							.trim()))
				hql.append(" and t.warnContent like '%").append(
						gosRegionWarnQueryBean.getWarnContent()).append("%'");
			if (gosRegionWarnQueryBean.getWarnLevel() != null
					&& gosRegionWarnQueryBean.getWarnLevel().longValue() != 0)
				hql.append(" and t.warnLevel = ").append(
						gosRegionWarnQueryBean.getWarnLevel());
			if (gosRegionWarnQueryBean.getWarnRegion() != null
					&& gosRegionWarnQueryBean.getWarnRegion().longValue() != 0)
				hql.append(" and t.warnRegion = ").append(
						gosRegionWarnQueryBean.getWarnRegion());
			if (gosRegionWarnQueryBean.getCreateDate() != null)
				hql.append(" and t.createDate = to_date('").append(
						gosRegionWarnQueryBean.getCreateDate()).append(
						"','yyyy-MM-dd')");
			if (gosRegionWarnQueryBean.getUseFlag() != null)
				hql.append(" and t.useFlag = ").append(
						gosRegionWarnQueryBean.getUseFlag());
			if (gosRegionWarnQueryBean.getCreateUserId() != null
					&& gosRegionWarnQueryBean.getCreateUserId().longValue() != 0)
				hql.append(" and t.createUserId = ").append(
						gosRegionWarnQueryBean.getCreateUserId());
		}
		if (page != null) {
			StringBuffer countHql = new StringBuffer("select count(*) ");
			return dao.query(hql.toString(), countHql.toString()
					+ hql.toString(), page);
		}
		return dao.queryList(hql.toString());

		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(GosRegionWarn.class,"t");
		// criteria.createAlias("t.apDeadApply", "d");
		// Projection projection = Projections.projectionList().add(
		// Projections.property("t.id")).add(
		// Projections.property("t.countyId")).add(
		// Projections.property("t.streetId")).add(
		// Projections.property("t.name")).add(
		// Projections.property("t.idCards")).add(
		// Projections.property("t.state")).add(
		// Projections.property("d.applyName")).add(
		// Projections.property("d.applyIdCards")).add(
		// Projections.property("d.acceptDate"));
		// criteria.setProjection(projection);
	}
	
	
	/** 
     * 将Date类型时间转换为字符串 
     * @param date 
     * @return 
     * @author zp
     */  
    public static String toDateString(Date date) {  
        String time;  
        SimpleDateFormat formater = new SimpleDateFormat();  
        formater.applyPattern("yyyy-MM-dd");  
        time = formater.format(date);  
        return time;  
    } 
}
