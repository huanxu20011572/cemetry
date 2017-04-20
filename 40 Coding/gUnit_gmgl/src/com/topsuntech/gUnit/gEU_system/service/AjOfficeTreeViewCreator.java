package com.topsuntech.gUnit.gEU_system.service;

import java.util.List;

import com.topsuntech.gOS.identity.model.tree.TreeNode;
import com.topsuntech.gOS.identity.office.service.OfficeTreeViewCreator;
import com.topsuntech.gUnit.gEU_util.entity.AjDept;

public class AjOfficeTreeViewCreator extends OfficeTreeViewCreator {

	private String userRegion;

	public TreeNode[] convertOfficesToTreeNodes(List offices) {
		TreeNode[] treeNodes = null;
		if ("true".equals(userRegion)) {
			treeNodes = new AjTreeNode[offices.size()];
			for (int i = 0; i < offices.size(); i++) {
				AjDept ajDept = (AjDept) offices.get(i);
				AjTreeNode ajTreeNode = new AjTreeNode();
				ajTreeNode.setId(ajDept.getId().toString());
				ajTreeNode.setName(ajDept.getName());
				ajTreeNode.setpId(ajDept.getParentId().toString());
//				ajTreeNode.setRegion(ajDept.getIsRegion() == null ? false : ajDept.getIsRegion().booleanValue());
				ajTreeNode.setRegionId(ajDept.getRegionId());
				
				treeNodes[i] = ajTreeNode;
			}
		} else {
			treeNodes = super.convertOfficesToTreeNodes(offices);
		}
		return treeNodes;
	}

	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}

	public static class AjTreeNode extends TreeNode {
		private boolean region;

		private Long regionId;

		public boolean isRegion() {
			return region;
		}

		public void setRegion(boolean region) {
			this.region = region;
		}

		public Long getRegionId() {
			return regionId;
		}

		public void setRegionId(Long regionId) {
			this.regionId = regionId;
		}
	}
}
