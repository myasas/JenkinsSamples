def repo_url = scm.getUserRemoteConfigs()[0].getUrl()
def repo_credentials_id = scm.getUserRemoteConfigs()[0].getCredentialsId()


pipeline {
    agent any 


    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
                sh 'env'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: repo_credentials_id, url: repo_url]]])    
            }
        }
    }
}
