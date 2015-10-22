<%@include file="/html/init.jsp"%>

This is the <b>liferay-publication</b>.
<div id="<portlet:namespace />publicationContainer">
    <aui:row cssClass="lfr-app-column-view">
        <aui:col cssClass="navigation-pane" width="<%= 20 %>">
            <jsp:include page="/html/publication/admin/view_folders.jsp" />

            <div class="folder-pagination"></div>
        </aui:col>

        <aui:col cssClass="context-pane" last="<%= true %>" width="<%= 80 %>">
            <liferay-ui:app-view-toolbar
                    includeDisplayStyle="<%= true %>"
                    includeSelectAll="<%= true %>"
                    >
                <jsp:include page="/html/publication/admin/toolbar.jsp" />
            </liferay-ui:app-view-toolbar>


            <%
                //PortletURL portletURL = liferayPortletResponse.createRenderURL();

                //portletURL.setParameter("struts_action", "/journal/edit_article");
                //portletURL.setParameter("folderId", String.valueOf(folderId));
            %>

            <aui:form action="" method="get" name="fm">
                <aui:input name="" type="hidden" />
                <aui:input name="redirect" type="hidden" value="" />
                <aui:input name="folderIds" type="hidden" />
                <aui:input name="articleIds" type="hidden" />
                <aui:input name="newFolderId" type="hidden" />

                <div class="product-container" id="<portlet:namespace />entriesContainer">
                    <jsp:include page="/html/publication/admin/view_entries.jsp" />
                </div>

                <div class="product-entries-pagination"></div>
            </aui:form>
        </aui:col>
    </aui:row>
</div>