node{
  stage('SCM checkout'){
    git 'https://github.com/tejfi/Jira-Glass-documentation-test.git'
  }
  stage('compile-package){
  sh 'mvn package'
  }
}
