Hi, while doing chapter 16, I'm experiencing problems with the `test-em-all.bash` script when it is running in a Kubernetes cluster.

I did try to reproduce what you did in the section "Deploying to Kubernetes for development and test". Since I have a Mac M1, I had to adapt your version of the project (See []()). My version can be found on GitHub at the following URL: [Chapter16_init](https://github.com/hjoly2003/Chapter16_Init). A detailed description of the steps can be found in the section [Deploying to Kubernetes for development and test](https://github.com/hjoly2003/Chapter16_Init/blob/master/README.md#deploy_and_test_id) of the README.md file.

Initially, I started a cluster as described in the [README.md](https://github.com/hjoly2003/Chapter16_Init/blob/master/README.md).
Then, for gradle to build successfully, I had to skip the unit tests since some were failing (outside of the minikube environment, they all pass). 
I was able to follow your instructions without problem up to the "test_em_all.sh" script. When we start the script, it waits for ever for a response from the actuator health. 
```
Start Tests: Ven 27 jan 2023 07:22:53 EST
HOST=192.168.67.2
PORT=30443
USE_K8S=true
SKIP_CB_TESTS=false
Wait for: curl -k https://192.168.67.2:30443/actuator/health... , retry #1 , retry #2 , retry #3 , retry #4 , retry #5 , retry #6 , retry #7 , retry #8
```
I hope that in my GitHub repository, you'll find everything you need to diagnose the problem.

Finally, I'd like to thank you for your book. So far, it is the most complete reference on the subject and I would recommend it to everyone.

Thanks in advance,

Hugues Joly