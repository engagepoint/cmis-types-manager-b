package com.engagepoint;

import org.apache.chemistry.opencmis.client.api.ObjectType;
import org.apache.chemistry.opencmis.client.api.Tree;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class TreeBean implements Serializable {
    @EJB
    private CmisService service;
    @Inject
    private LoginController login;
    private TreeNode root;
    private CmisType selectedType;

    private TreeNode selectedNode;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Root", null);
        LoginInfo loginInfo = login.getLoginInfo();
        List<Tree<ObjectType>> trees = service.getTreeTypes(loginInfo);
       if (trees != null) {
           List<CmisType> cmisTypeList = getListType(trees);
           addTypesToTreeNode(cmisTypeList, root);
        }
    }

    protected void refreshPage() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String refreshpage = fc.getViewRoot().getViewId();
        ViewHandler ViewH =fc.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fc,refreshpage);
        UIV.setViewId(refreshpage);
        fc.setViewRoot(UIV);
    }

    private List<CmisType> getListType(List<Tree<ObjectType>> treeList){
        List<CmisType> cmisTypeList = new ArrayList<CmisType>();

        for (Tree<ObjectType> tree : treeList) {
            cmisTypeList.add(getTypeObject(tree.getItem()));
        }
        return cmisTypeList;
    }

    private CmisType getTypeObject(ObjectType objectType){
        CmisType cmisType = new CmisType();
        cmisType.setName(objectType.getDisplayName());
        cmisType.setId(objectType.getId());
        cmisType.setCreatable(objectType.isCreatable());
        cmisType.setFileable(objectType.isFileable());
        List<CmisType> children = new ArrayList<CmisType>();
        for (ObjectType child : objectType.getChildren()) {
            children.add(getTypeObject(child));
        }
        cmisType.setChildren(children);
        return cmisType;
    }



    public TreeBean() {


    }

    public TreeNode getRoot() {
        return root;
    }

    public CmisType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(CmisType selectedDocument) {
        this.selectedType = selectedDocument;
    }

    private void addTypesToTreeNode(List<CmisType> cmisTypes, TreeNode parent) {
        for (CmisType cmisType : cmisTypes) {
            TreeNode node = new DefaultTreeNode(cmisType, parent);
            if (!cmisType.getChildren().isEmpty()) {
                addTypesToTreeNode(cmisType.getChildren(), node);
            }
        }
    }
}