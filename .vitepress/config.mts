import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "OSK Tools",
  base: "/",
  lang: "zh-CN",
  description: "OSK Tools by binstdio",
  lastUpdated: true,
  cleanUrls: true,
  sitemap: {hostname: 'https://osk.binstdio.us.kg'},
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: '主页', link: '/' },
      { text: '指南', link: '/docs/guide/' },
      { text: '参考', link: '/docs/refer/'},
      { text: '开发', link: '/docs/dev/'}
    ],

    sidebar: {
      '/docs/guide': [
        {
          text: '开始',
          collapsed: false,
          items: [
            { text: '什么是 OSK Tools？', link: '/docs/guide/' },
            { text: '快速安装', link: '/docs/guide/install' },
            { text: '鸣谢', link: '/docs/guide/thanks' }
          ]
        },
        {
          text: '其他',
          collapsed: false,
          items: [
            { text: '团队页', link: '/docs/team/' },
          ]
        },
      ],
    },

    socialLinks: [
      { icon: 'github', link: 'https://github.com/binstdio/OSK-Tools' }
    ],
    editLink: {
      pattern: 'https://github.com/binstdio/OSK-Tools/edit/web/:path',
      text: '在 GitHub 上编辑此页面'
    },

    lastUpdated: {
      text: '本文档最后更新于',
      formatOptions: {
        dateStyle: 'full',
        timeStyle: 'medium',
      }
    },
    
    footer: {
      copyright: '版权所有 © 2025 <a href="https://github.com/binstdio" target="_blank">冰川工作室</a>'
    },
    search: {
      provider: 'local',
      options: {
            translations: {
              button: {
                buttonText: '搜索文档',
                buttonAriaLabel: '搜索文档'
              },
              modal: {
                noResultsText: '无法找到相关结果',
                resetButtonTitle: '清除查询条件',
                footer: {
                  selectText: '选择',
                  navigateText: '切换',
                  closeText: '关闭'
                }
              }
            }
          }
        },
    outline: {
      label: '本页面内导航',
      level: [2,3]
    },
        docFooter: {
          prev: '上一页',
          next: '下一页',
      },
      langMenuLabel: '多语言',
      returnToTopLabel: '回到顶部',
      sidebarMenuLabel: '菜单',
      darkModeSwitchLabel: '主题',
      lightModeSwitchTitle: '切换到浅色模式',
      darkModeSwitchTitle: '切换到深色模式',
    },
})
