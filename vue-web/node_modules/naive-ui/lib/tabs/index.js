"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.NTab = exports.NTabPane = exports.NTabs = void 0;
var Tabs_1 = require("./src/Tabs");
Object.defineProperty(exports, "NTabs", { enumerable: true, get: function () { return __importDefault(Tabs_1).default; } });
var TabPane_1 = require("./src/TabPane");
Object.defineProperty(exports, "NTabPane", { enumerable: true, get: function () { return __importDefault(TabPane_1).default; } });
var Tab_1 = require("./src/Tab");
Object.defineProperty(exports, "NTab", { enumerable: true, get: function () { return __importDefault(Tab_1).default; } });
