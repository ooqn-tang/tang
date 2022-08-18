import commonVariables from './_common';
import { commonLight } from '../../_styles/common';
export const self = (vars) => {
    const { fontSize, textColor3, primaryColorHover, primaryColorPressed, textColor2 } = vars;
    return Object.assign(Object.assign({}, commonVariables), { fontSize: fontSize, itemTextColor: textColor3, itemTextColorHover: primaryColorHover, itemTextColorPressed: primaryColorPressed, itemTextColorActive: textColor2, separatorColor: textColor3 });
};
const breadcrumbLight = {
    name: 'Breadcrumb',
    common: commonLight,
    self
};
export default breadcrumbLight;
