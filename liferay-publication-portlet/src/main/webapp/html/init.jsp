<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.model.Portlet" %>
<%@ page import="com.liferay.portal.service.PortletLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.trash.util.TrashUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="fr.lagab.portlet.publication.web.util.PortletKeys" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>

<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.NoSuchStructureException" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.NoSuchTemplateException" %>
<%@ page import="com.liferay.portal.NoSuchRepositoryEntryException" %>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="com.liferay.taglib.aui.AUIUtil" %>
<%@ page import="java.util.Date" %>

<%@ page import="fr.lagab.portlet.publication.model.Publication" %>
<%@ page import="fr.lagab.portlet.publication.web.util.PublicationPermission" %>
<%@ page import="fr.lagab.portlet.publication.service.PublicationServiceUtil" %>
<%@ page import="fr.lagab.portlet.publication.web.search.PublicationSearch" %>
<%@ page import="fr.lagab.portlet.publication.web.util.PublicationUtil" %>
<%@ page import="fr.lagab.portlet.publication.web.search.PublicationDisplayTerms" %>
<%@ page import="fr.lagab.portlet.publication.web.search.PublicationSearchTerms" %>
<%@ page import="fr.lagab.portlet.publication.PublicationTitleException" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
    PortletMode portletMode = liferayPortletRequest.getPortletMode();
    WindowState windowState = liferayPortletRequest.getWindowState();

    PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);
    String[] displayViews = {"icon","descriptive"};

    PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);

    String currentURL = currentURLObj.toString();
    String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

    String relatedCategoryId = PrefsParamUtil.getString(portletPreferences, request, "categoryId", StringPool.BLANK);
    relatedCategoryId = StringUtil.merge(portletPreferences.getValues("categoryId", StringPool.EMPTY_ARRAY), StringPool.COMMA_AND_SPACE);
%>