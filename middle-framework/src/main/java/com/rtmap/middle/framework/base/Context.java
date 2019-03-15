package com.rtmap.middle.framework.base;

/**
 * 登录者上下文信息
 */
public class Context {

    private static ThreadLocal<Context> context = new ThreadLocal<>();

    public static void setLocalContext(String tenantId, String tenantType, String cid, String openId, String role) {
        Context cxt = new Context(tenantId, tenantType, cid, openId, role);
        context.set(cxt);
    }

    public static Context getLocalContext() {
        return context.get();
    }

    public static void removeLocalContext() {
        context.remove();
    }

    private Context(String tenantId, String tenantType, String cid, String openId, String role) {
        this.tenantId = tenantId;
        this.tenantType = tenantType;
        this.cid = cid;
        this.openId = openId;
        this.role = role;
    }

    private String tenantId;
    private String tenantType;
    private String role;
    private String cid;
    private String openId;

    public String getRole() {
        return this.role;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantType() {
        return this.tenantType;
    }

    public String getCid() {
        return this.cid;
    }

    public String getOpenId() {
        return this.openId;
    }
}
