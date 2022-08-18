import type { ThemeCommonVars } from '../../_styles/common';
export declare const self: (vars: ThemeCommonVars) => {
    bodyPadding: string;
    headerPadding: string;
    footerPadding: string;
    color: string;
    textColor: string;
    titleTextColor: string;
    titleFontSize: string;
    titleFontWeight: string;
    boxShadow: string;
    lineHeight: string;
    headerBorderBottom: string;
    footerBorderTop: string;
    closeColor: string;
    closeColorHover: string;
    closeColorPressed: string;
    closeSize: string;
};
export declare type DrawerThemeVars = ReturnType<typeof self>;
declare const drawerLight: import("../../_mixins").Theme<"Drawer", {
    bodyPadding: string;
    headerPadding: string;
    footerPadding: string;
    color: string;
    textColor: string;
    titleTextColor: string;
    titleFontSize: string;
    titleFontWeight: string;
    boxShadow: string;
    lineHeight: string;
    headerBorderBottom: string;
    footerBorderTop: string;
    closeColor: string;
    closeColorHover: string;
    closeColorPressed: string;
    closeSize: string;
}, {
    Scrollbar: import("../../_mixins").Theme<"Scrollbar", {
        color: string;
        colorHover: string;
    }, any>;
}>;
export default drawerLight;
export declare type DrawerTheme = typeof drawerLight;
