---
layout: page
title: "团队名单"
---
<script setup>
import {
  VPTeamPage,
  VPTeamPageTitle,
  VPTeamMembers
} from 'vitepress/theme'

const members = [
  {
    avatar: 'https://github.com/upbingun.png',
    name: 'upbingun',
    title: '冰川工作室创始人 & 工作室所有者',
    links: [
      { icon: 'github', link: 'https://github.com/upbingun' },
    ]
  },
  {
    avatar: 'https://github.com/XiaoYv.png',
    name: 'XiaoYv',
    title: '冰川工作室主任',
    links: [
      { icon: 'github', link: 'https://github.com/XiaoYv' },
    ]
  },
  {
    avatar: 'https://github.com/Ad-closeNN.png',
    name: 'Ad_closeNN',
    title: '网站编辑负责人',
    links: [
      { icon: 'github', link: 'https://github.com/upbingun' },
      { icon: 'x', link: 'https://x.com/Ad_Cattt' },
      { icon: 'youtube', link: 'https://www.youtube.com/@Ad-closeNN' }, 
    ]
  },
]
</script>

<VPTeamPage>
  <VPTeamPageTitle>
    <template #title>
      我们的团队
    </template>
    <template #lead>
      冰川工作室<br><br>
      冰川工作室的发展离不开成员的努力与相互之间的配合。
    </template>
  </VPTeamPageTitle>
  <VPTeamMembers
    :members="members"
  />
</VPTeamPage>