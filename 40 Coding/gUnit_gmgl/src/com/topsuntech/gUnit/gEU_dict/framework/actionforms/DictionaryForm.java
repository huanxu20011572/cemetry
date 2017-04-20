
//---------------------------------------------------------
// Application: Auto Config Management
// Author     : Hechuan
//
// Copyright ? 2004 Beijing Topsun Technology CO.,LTD.
// Generated at Fri Apr 30 10:38:10 CST 2004
// Created with Autocode - the RAD tool for J2EE
// http://www.topsuntech.com
//---------------------------------------------------------

package com.topsuntech.gUnit.gEU_dict.framework.actionforms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.topsuntech.gUnit.gEU_dict.en.MetaData;



/**
* The ActionForm object is used to hold and validate values for the Common form.
*/
public class DictionaryForm extends ActionForm
{

	// attributes


      // the node_level
            private Integer node_level;
            // the node_typename
            private String node_typename;
            // the node_value
            private String node_value;
            // the parentid
            private Long parentid;
            // the node_index
            private Long node_index;
            // the node_name
            private String node_name;
            // the id
            private Long id;
            
            private Long institutionid; //À˘ Ù¿‡–Õ



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



  // Contract methods

  /**
  * validate the submitted values
  */
  public ActionErrors validate(ActionMapping mapping,
                               HttpServletRequest request) {

      return null;

  } // end of validate

  /**
  * This resets all the form values back to defaults, part of struts framework
  */
  public void reset(ActionMapping mapping,
                    HttpServletRequest request) {

      node_level = null;
      node_typename = null;
      node_value = null;
      parentid = null;
      node_index = null;
      node_name = null;
      id = null;
      institutionid = null;

  } // end of reset

	public MetaData populate(){
		MetaData bean = new MetaData();
	    bean.setNode_level(getNode_level());
		bean.setNode_typename(getNode_typename());
		bean.setNode_value(getNode_value());
		bean.setParentid(getParentid());
		bean.setNode_index(getNode_index());
		bean.setNode_name(getNode_name());
		bean.setId(getId());
		bean.setInstitutionid(getInstitutionid());
	    return bean;
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
}// end of CommonForm
