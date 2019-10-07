node{
   environment {
     env.SEHUB_USERNAME='selenium'
     env.SEHUB_PW='CoolCanvas19.'
     env.SEHUB_URL='seleniumhub.codecool.codecanvas.hu/wd/hub'
     env.JIRA_USERNAME='user17'
     env.JIRA_PASSWORD='CoolCanvas19.'
     env.JAVA_HOME = /usr/bin/java
   }
  stage('SCM checkout'){
    git 'https://github.com/tejfi/Jira-Glass-documentation-test.git'
  }
  stage('compile-package'){
    sh 'mvn package'
  }
}
