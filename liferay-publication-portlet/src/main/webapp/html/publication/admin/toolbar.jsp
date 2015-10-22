<%@ include file="/html/init.jsp" %>

<%
    String strutsAction = ParamUtil.getString(request, "struts_action");
%>

<aui:nav-bar>
    <aui:nav collapsible="<%= false %>" cssClass="nav-display-style-buttons pull-right" id="displayStyleButtons">
        <aui:nav-item>
			<span class="pull-left display-style-buttons-container" id="<portlet:namespace />displayStyleButtonsContainer">
				<c:if test='<%= !strutsAction.equals("/journal/search") %>'>
                    <liferay-util:include page="/html/portlet/journal/display_style_buttons.jsp" />
                </c:if>
			</span>
        </aui:nav-item>
    </aui:nav>

    <aui:nav id="toolbarContainer">
        <aui:nav-item cssClass="hide" dropdown="<%= true %>" id="actionsButtonContainer" label="actions">

            <%
                String taglibURL = "javascript:Liferay.fire('" + renderResponse.getNamespace() + "editEntry', {action: '" + Constants.EXPIRE + "'}); void(0);";
            %>

            <aui:nav-item href="<%= taglibURL %>" label="expire" />

            <%
                taglibURL = "javascript:Liferay.fire('" + renderResponse.getNamespace() + "editEntry', {action: '" + Constants.MOVE + "'}); void(0);";
            %>

            <aui:nav-item href="<%= taglibURL %>" label="move" />

            <%
                taglibURL = "javascript:" + renderResponse.getNamespace() + "deleteEntries();";
            %>

            <aui:nav-item href="<%= taglibURL %>" iconCssClass='<%= TrashUtil.isTrashEnabled(scopeGroupId) ? "icon-trash" : "icon-remove" %>' label='<%= TrashUtil.isTrashEnabled(scopeGroupId) ? "move-to-the-recycle-bin" : "delete" %>' />
        </aui:nav-item>

        <jsp:include page="/html/publication/admin/add_button.jsp" />

        <jsp:include page="/html/publication/admin/sort_button.jsp" />

        <c:if test="<%= !user.isDefaultUser() %>">
            <aui:nav-item dropdown="<%= true %>" label="manage">

                <%
                    String taglibURL = "javascript:" + renderResponse.getNamespace() + "openStructuresView()";
                %>

                <aui:nav-item href="<%= taglibURL %>" iconCssClass="icon-tasks" label="structures" />

            </aui:nav-item>
        </c:if>
    </aui:nav>

    <aui:nav-bar-search cssClass="pull-right" file="/html/portlet/journal/article_search.jsp" />
</aui:nav-bar>

<aui:script>

    <%
        Portlet portlet = PortletLocalServiceUtil.getPortletById(portletDisplay.getId());
    %>

    function <portlet:namespace />deleteEntries() {
        if (<%= TrashUtil.isTrashEnabled(scopeGroupId) %> || confirm(' <%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
            Liferay.fire(
            '<%= renderResponse.getNamespace() %>editEntry',
            {
                action: '<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>'
            }
            );
        }
    }

    function <portlet:namespace />openStructuresView() {
    Liferay.Util.openDDMPortlet(
    {
        basePortletURL: '<%= PortletURLFactoryUtil.create(request, PortletKeys.DYNAMIC_DATA_MAPPING, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>',
        dialog: {
            destroyOnHide: true,
            on: {
                visibleChange: function(event) {
                    if (!event.newVal) {
                        Liferay.Portlet.refresh('#p_p_id_<%= portletDisplay.getId() %>_');
                    }
                }
            }
        },
        refererPortletName: '<%= PortletKeys.PUBLICATION_PORTLET %>',
        refererWebDAVToken: '<%= portlet.getWebDAVStorageToken() %>',
        showGlobalScope: false,
        showManageTemplates: true,
        title: '<%= UnicodeLanguageUtil.get(pageContext, "structures") %>'
    }
    );
    }
</aui:script>