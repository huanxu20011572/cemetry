//---------------------------------------------------------
// Application: Auto Config Management
// Author     : Hechuan
//
// Copyright ? 2004 Beijing Topsun Technology CO.,LTD.
// Generated at Fri Apr 30 10:38:10 CST 2004
// Created with Autocode - the RAD tool for J2EE
// http://www.topsuntech.com
//---------------------------------------------------------

package com.topsuntech.gUnit.gEU_dict.en;

import java.util.ArrayList;
import java.util.List;

/**
 * 原数据
 */
public class MetaData implements java.io.Serializable {

    // attributes
    private List details;

    public List getDetails() {
        return details;
    }

    public void setDetails(List detailList) {
        this.details = detailList;
    }

    public void addDetail(MetaData bean) {
        if (details == null) {
            details = new ArrayList();
        }

        details.add(bean);
    }

    /**
     * 节点所在层数
     */
    private Integer node_level;

    /**
     * 节点所属名称
     */
    private String node_typename;

    /**
     * 节点特定值
     */
    private String node_value;

    /**
     * 父节点ID
     */
    private Long parentid;

    /**
     * 节点序列号
     */
    private Long node_index;

    /**
     * 节点名称
     */
    private String node_name;

    /**
     * 节点ID
     */
    private Long id;
    
    /**
     * 机构ID
     */
    private Long institutionid;
    
    /**
     * 状态
     */
    private Integer state;


    // attribute getters/setters
    /**
     * returns the value of the NODE_LEVEL
     *
     * @return the node_level
     */
    public Integer getNode_level() {
        return node_level;
    }

    /**
     * sets the value of the NODE_LEVEL
     *
     * @param node_level the NODE_LEVEL
     */
    public void setNode_level(Integer node_level) {
        this.node_level = node_level;
    }

    /**
     * returns the value of the NODE_TYPENAME
     *
     * @return the node_typename
     */
    public String getNode_typename() {
        return node_typename;
    }

    /**
     * sets the value of the NODE_TYPENAME
     *
     * @param node_typename the NODE_TYPENAME
     */
    public void setNode_typename(String node_typename) {
        this.node_typename = node_typename;
    }

    /**
     * returns the value of the NODE_VALUE
     *
     * @return the node_value
     */
    public String getNode_value() {
        return node_value;
    }

    /**
     * sets the value of the NODE_VALUE
     *
     * @param node_value the NODE_VALUE
     */
    public void setNode_value(String node_value) {
        this.node_value = node_value;
    }

    /**
     * returns the value of the PARENTID
     *
     * @return the parentid
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * sets the value of the PARENTID
     *
     * @param parentid the PARENTID
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * returns the value of the NODE_INDEX
     *
     * @return the node_index
     */
    public Long getNode_index() {
        return node_index;
    }

    /**
     * sets the value of the NODE_INDEX
     *
     * @param node_index the NODE_INDEX
     */
    public void setNode_index(Long node_index) {
        this.node_index = node_index;
    }

    /**
     * returns the value of the NODE_NAME
     *
     * @return the node_name
     */
    public String getNode_name() {
        return node_name;
    }

    /**
     * sets the value of the NODE_NAME
     *
     * @param node_name the NODE_NAME
     */
    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    /**
     * returns the value of the ID
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * sets the value of the ID
     *
     * @param id the ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    private String prefixcode; //前缀代码
    private Integer belongtype; //所属类型    

    public MetaData(){
    	
    }
    
   public MetaData(Long id,String node_name,String node_typeValue){
    	this.id=id;
    	this.node_name=node_name;
    	this.node_value=node_typeValue;
    }
	/**
	 * @return Returns the belongtype.
	 */
	public Integer getBelongtype() {
		return belongtype;
	}
	/**
	 * @param belongtype The belongtype to set.
	 */
	public void setBelongtype(Integer belongtype) {
		this.belongtype = belongtype;
	}
	/**
	 * @return Returns the prefixcode.
	 */
	public String getPrefixcode() {
		return prefixcode;
	}
	/**
	 * @param prefixcode The prefixcode to set.
	 */
	public void setPrefixcode(String prefixcode) {
		this.prefixcode = prefixcode;
	}
	/**
	 * @return Returns the institutionid.
	 */
	public Long getInstitutionid() {
		return institutionid;
	}
	/**
	 * @param institutionid The institutionid to set.
	 */
	public void setInstitutionid(Long institutionid) {
		this.institutionid = institutionid;
	}
	
	
	/**
	 * @return Returns the state.
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state The state to set.
	 */
	public void setState(Integer state) {
		this.state = state;
	}
} // end Common
