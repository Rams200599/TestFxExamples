pipeline {
  agent any
  stages {
    stage('Start Xvfb') {
      steps {
        sh 'Xvfb :1 -screen 0 1024x768x24 > /dev/null 2>&1 &'
        sh 'export DISPLAY=:1'
      }
    }

    stage('Test') {
      steps {
        sh 'export DISPLAY=:1.0 && mvn test'
      }
    }

    stage('Build') {
      steps {
        sh 'export DISPLAY=:1.0 && mvn clean package'
      }
    }

  }
}