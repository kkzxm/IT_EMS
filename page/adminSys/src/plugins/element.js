import { ElButton ,ElForm} from 'element-plus'
import lang from 'element-plus/lib/locale/lang/zh-cn'
import locale from 'element-plus/lib/locale'
import 'element-plus/lib/theme-chalk/index.css';
export default (app) => {
  locale.use(lang)
  app.use(ElButton,ElForm)
}
