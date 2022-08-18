"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const dropdown_1 = require("../../../dropdown");
const _internal_1 = require("../../../_internal");
const icons_1 = require("../../../_internal/icons");
const interface_1 = require("../interface");
const allKey = '_n_all__';
const noneKey = '_n_none__';
function createSelectHandler(options, rawPaginatedDataRef, doCheckAll, doUncheckAll) {
    if (!options)
        return () => { };
    return (key) => {
        for (const option of options) {
            switch (key) {
                case allKey:
                    doCheckAll(true);
                    return;
                case noneKey:
                    doUncheckAll(true);
                    return;
                default:
                    if (typeof option === 'object' && option.key === key) {
                        option.onSelect(rawPaginatedDataRef.value);
                        return;
                    }
            }
        }
    };
}
function createDropdownOptions(options, localeRef) {
    if (!options)
        return [];
    return options.map((option) => {
        switch (option) {
            case 'all':
                return {
                    label: localeRef.checkTableAll,
                    key: allKey
                };
            case 'none':
                return {
                    label: localeRef.uncheckTableAll,
                    key: noneKey
                };
            default:
                return option;
        }
    });
}
exports.default = (0, vue_1.defineComponent)({
    name: 'DataTableSelectionMenu',
    props: {
        clsPrefix: {
            type: String,
            required: true
        }
    },
    setup() {
        const { localeRef, checkOptionsRef, rawPaginatedDataRef, doCheckAll, doUncheckAll
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
         } = (0, vue_1.inject)(interface_1.dataTableInjectionKey);
        return {
            handleSelect: (0, vue_1.computed)(() => createSelectHandler(checkOptionsRef.value, rawPaginatedDataRef, doCheckAll, doUncheckAll)),
            options: (0, vue_1.computed)(() => createDropdownOptions(checkOptionsRef.value, localeRef.value))
        };
    },
    render() {
        const { clsPrefix } = this;
        return ((0, vue_1.h)(dropdown_1.NDropdown, { options: this.options, onSelect: this.handleSelect }, {
            default: () => ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix, class: `${clsPrefix}-data-table-check-extra` }, {
                default: () => (0, vue_1.h)(icons_1.ChevronDownIcon, null)
            }))
        }));
    }
});
