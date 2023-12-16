-- Question 1
USE quizdb;

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary goal of machine learning?',
  'Predict future outcomes',
  'Classify data',
  'Learn from data and improve over time',
  'All of the above',
  'All of the above',
  'MEDIUM',
  'Machine Learning'
);

-- Question 2
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which algorithm is commonly used for supervised learning classification tasks?',
  'K-Means',
  'Decision Trees',
  'Apriori',
  'PCA (Principal Component Analysis)',
  'Decision Trees',
  'MEDIUM',
  'Machine Learning'
);

-- Question 3
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of the activation function in a neural network?',
  'Define the learning rate',
  'Normalize the input data',
  'Introduce non-linearity',
  'Compute the gradient descent',
  'Introduce non-linearity',
  'MEDIUM',
  'Neural Networks'
);

-- Question 4
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'In machine learning, what does the term "overfitting" refer to?',
  'Model fits the training data too closely but fails to generalize',
  'Model is too simple and lacks complexity',
  'Model is perfectly balanced',
  'None of the above',
  'Model fits the training data too closely but fails to generalize',
  'MEDIUM',
  'Machine Learning'
);

-- Question 5
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What does the acronym SVM stand for in machine learning?',
  'Support Vector Machine',
  'Supervised Variance Model',
  'Sequential Validation Method',
  'Systematic Verification Mechanism',
  'Support Vector Machine',
  'MEDIUM',
  'Machine Learning'
);

-- Question 6
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which type of machine learning algorithm is used for labeling input data?',
  'Supervised Learning',
  'Unsupervised Learning',
  'Reinforcement Learning',
  'Semi-Supervised Learning',
  'Supervised Learning',
  'MEDIUM',
  'Machine Learning'
);

-- Question 7
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What does the term "gradient descent" refer to in the context of machine learning?',
  'A supervised learning algorithm',
  'An optimization algorithm for finding the minimum of a function',
  'A type of neural network architecture',
  'A method for clustering data',
  'An optimization algorithm for finding the minimum of a function',
  'MEDIUM',
  'Machine Learning'
);

-- Question 8
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which evaluation metric is commonly used for binary classification problems?',
  'Mean Absolute Error (MAE)',
  'Root Mean Squared Error (RMSE)',
  'Accuracy',
  'F1 Score',
  'Accuracy',
  'MEDIUM',
  'Machine Learning'
);

-- Question 9
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of cross-validation in machine learning?',
  'To ensure the model fits the training data perfectly',
  'To evaluate a models performance on unseen data',
  'To train a model on multiple datasets simultaneously',
  'To replace traditional training-validation splits',
  'To evaluate a model''s performance on unseen data',
  'MEDIUM',
  'Machine Learning'
);

-- Question 10
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which machine learning algorithm is often used for anomaly detection?',
  'Linear Regression',
  'K-Means Clustering',
  'Decision Trees',
  'Support Vector Machine',
  'Support Vector Machine',
  'MEDIUM',
  'Machine Learning'
);

-- Question 11
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of regularization in machine learning models?',
  'To increase model complexity',
  'To decrease model complexity',
  'To add noise to the training data',
  'To remove outliers from the dataset',
  'To decrease model complexity',
  'MEDIUM',
  'Machine Learning'
);

-- Question 12
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'In natural language processing, what does "TF-IDF" stand for?',
  'Term Frequency-Inverse Document Frequency',
  'Text Feature-Identifying Document Frequency',
  'Token Frequency-Inverted Data Filter',
  'Time Frame-Incremental Document Factor',
  'Term Frequency-Inverse Document Frequency',
  'MEDIUM',
  'Natural Language Processing'
);

-- Question 13
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which algorithm is suitable for collaborative filtering in recommendation systems?',
  'K-Nearest Neighbors (KNN)',
  'Random Forest',
  'Support Vector Machine',
  'Principal Component Analysis (PCA)',
  'K-Nearest Neighbors (KNN)',
  'MEDIUM',
  'Recommendation Systems'
);

-- Question 14
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary difference between bagging and boosting in ensemble learning?',
  'Bagging combines weak learners, while boosting assigns weights to misclassified instances',
  'Bagging assigns weights to misclassified instances, while boosting combines weak learners',
  'There is no difference between bagging and boosting',
  'Bagging and boosting are the same concepts',
  'Bagging combines weak learners, while boosting assigns weights to misclassified instances',
  'MEDIUM',
  'Ensemble Learning'
);

-- Question 15
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which algorithm is commonly used for image recognition tasks?',
  'Linear Regression',
  'K-Means Clustering',
  'Convolutional Neural Network (CNN)',
  'Naive Bayes Classifier',
  'Convolutional Neural Network (CNN)',
  'MEDIUM',
  'Computer Vision'
);

-- Question 16
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of cross-entropy loss in neural networks?',
  'To measure the difference between predicted and actual probabilities',
  'To calculate the mean squared error',
  'To optimize model parameters for classification tasks',
  'To normalize input data',
  'To measure the difference between predicted and actual probabilities',
  'MEDIUM',
  'Neural Networks'
);

-- Question 17
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which technique is used to handle missing data in a dataset?',
  'Data Aggregation',
  'Data Imputation',
  'Data Interpolation',
  'Data Normalization',
  'Data Imputation',
  'MEDIUM',
  'Data Preprocessing'
);

-- Question 18
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of the Kullback-Leibler (KL) divergence in probability theory?',
  'To measure the similarity between two probability distributions',
  'To calculate the absolute difference between two numbers',
  'To assess the variance of a dataset',
  'To normalize data for machine learning models',
  'To measure the similarity between two probability distributions',
  'MEDIUM',
  'Probability Theory'
);

-- Question 19
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which dimensionality reduction technique is commonly used for feature extraction?',
  'Principal Component Analysis (PCA)',
  'Linear Discriminant Analysis (LDA)',
  't-Distributed Stochastic Neighbor Embedding (t-SNE)',
  'Independent Component Analysis (ICA)',
  'Principal Component Analysis (PCA)',
  'MEDIUM',
  'Dimensionality Reduction'
);

-- Question 20
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the role of the activation function in a neural network?',
  'To adjust the learning rate',
  'To introduce non-linearity',
  'To determine the number of layers',
  'To calculate the model accuracy',
  'To introduce non-linearity',
  'MEDIUM',
  'Neural Networks'
);

-- Question 21
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the main objective of unsupervised learning?',
  'To predict future outcomes',
  'To learn from labeled data',
  'To classify input data',
  'To discover patterns and relationships in data',
  'To discover patterns and relationships in data',
  'EASY',
  'Machine Learning'
);

-- Question 22
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which method is used for feature scaling in machine learning?',
  'Data Normalization',
  'Data Imputation',
  'Data Standardization',
  'Data Aggregation',
  'Data Standardization',
  'EASY',
  'Data Preprocessing'
);

-- Question 23
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of a confusion matrix in classification tasks?',
  'To visualize data distribution',
  'To evaluate the performance of a classification model',
  'To aggregate multiple datasets',
  'To calculate the mean squared error',
  'To evaluate the performance of a classification model',
  'EASY',
  'Machine Learning'
);

-- Question 24
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which machine learning algorithm is a type of ensemble learning using decision trees?',
  'Support Vector Machine',
  'K-Means Clustering',
  'Random Forest',
  'Linear Regression',
  'Random Forest',
  'EASY',
  'Ensemble Learning'
);

-- Question 25
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary goal of dimensionality reduction in machine learning?',
  'To increase the model complexity',
  'To reduce computational costs',
  'To remove outliers from the dataset',
  'To improve model interpretability',
  'To reduce computational costs',
  'HARD',
  'Dimensionality Reduction'
);

-- Question 26
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which type of machine learning algorithm uses both labeled and unlabeled data for training?',
  'Supervised Learning',
  'Unsupervised Learning',
  'Semi-Supervised Learning',
  'Reinforcement Learning',
  'Semi-Supervised Learning',
  'EASY',
  'Machine Learning'
);

-- Question 27
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What does the term "feature" refer to in the context of machine learning?',
  'A target variable',
  'A predictor variable',
  'A dataset column',
  'A validation set',
  'A predictor variable',
  'EASY',
  'Machine Learning'
);

-- Question 28
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which algorithm is used for binary classification problems in machine learning?',
  'K-Means Clustering',
  'Random Forest',
  'Decision Trees',
  'Logistic Regression',
  'Logistic Regression',
  'EASY',
  'Machine Learning'
);

-- Question 29
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of the training set in machine learning?',
  'To validate model performance',
  'To evaluate model accuracy',
  'To train the model parameters',
  'To test model generalization',
  'To train the model parameters',
  'EASY',
  'Machine Learning'
);

-- Question 30
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which technique is used to prevent overfitting in machine learning models?',
  'Regularization',
  'Normalization',
  'Standardization',
  'Imputation',
  'Regularization',
  'EASY',
  'Machine Learning'
);

-- Question 31
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary goal of linear regression in machine learning?',
  'Classification',
  'Clustering',
  'Prediction of a continuous variable',
  'Feature extraction',
  'Prediction of a continuous variable',
  'EASY',
  'Machine Learning'
);

-- Question 32
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which metric is commonly used to evaluate regression models?',
  'Accuracy',
  'Precision',
  'Mean Absolute Error (MAE)',
  'F1 Score',
  'Mean Absolute Error (MAE)',
  'EASY',
  'Machine Learning'
);

-- Question 33
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of the term "one-hot encoding" in machine learning?',
  'To normalize data',
  'To convert categorical variables into numerical format',
  'To handle missing data',
  'To scale features',
  'To convert categorical variables into numerical format',
  'EASY',
  'Machine Learning'
);

-- Question 34
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which algorithm is used for clustering in machine learning?',
  'Logistic Regression',
  'K-Means Clustering',
  'Decision Trees',
  'Support Vector Machine',
  'K-Means Clustering',
  'EASY',
  'Machine Learning'
);

-- Question 35
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary purpose of the "train-test split" in machine learning?',
  'To train the model on all available data',
  'To create a validation set',
  'To evaluate the model on unseen data',
  'To handle missing values',
  'To evaluate the model on unseen data',
  'EASY',
  'Machine Learning'
);



-- BLOCKCHAIN


-- Question 36
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the main purpose of a blockchain?',
  'To store and manage centralized data',
  'To facilitate peer-to-peer transactions',
  'To conduct physical transactions',
  'To regulate financial markets',
  'To facilitate peer-to-peer transactions',
  'EASY',
  'Blockchain'
);

-- Question 37
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is a smart contract in the context of blockchain?',
  'A legally binding agreement',
  'A self-executing contract with the terms directly written into code',
  'A contract that requires manual execution by third parties',
  'A contract for physical goods only',
  'A self-executing contract with the terms directly written into code',
  'EASY',
  'Blockchain'
);

-- Question 38
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which consensus algorithm is commonly used in public blockchains like Ethereum?',
  'Proof of Authority (PoA)',
  'Delegated Proof of Stake (DPoS)',
  'Proof of Work (PoW)',
  'Proof of Stake (PoS)',
  'Proof of Work (PoW)',
  'EASY',
  'Blockchain'
);

-- Question 39
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of a private key in blockchain cryptography?',
  'To publicly identify a user',
  'To encrypt data for public sharing',
  'To sign transactions and provide access to funds',
  'To verify the authenticity of blockchain nodes',
  'To sign transactions and provide access to funds',
  'EASY',
  'Blockchain'
);

-- Question 40
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which type of blockchain is permissionless and allows anyone to join and participate?',
  'Public Blockchain',
  'Private Blockchain',
  'Consortium Blockchain',
  'Hybrid Blockchain',
  'Public Blockchain',
  'EASY',
  'Blockchain'
);

-- Question 41
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is a blockchain node?',
  'A physical device that stores blockchain data',
  'A user account on a blockchain network',
  'A smart contract in blockchain',
  'A transaction record on a blockchain',
  'A physical device that stores blockchain data',
  'EASY',
  'Blockchain'
);

-- Question 42
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of consensus mechanisms in blockchain networks?',
  'To prevent access to blockchain data',
  'To facilitate transactions between users',
  'To reach agreement on the state of the blockchain',
  'To encrypt data on the blockchain',
  'To reach agreement on the state of the blockchain',
  'EASY',
  'Blockchain'
);

-- Question 43
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which cryptocurrency was the first to be created and implemented using blockchain technology?',
  'Ethereum',
  'Ripple (XRP)',
  'Bitcoin',
  'Litecoin',
  'Bitcoin',
  'EASY',
  'Blockchain'
);

-- Question 44
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the role of miners in a Proof of Work (PoW) blockchain?',
  'To create new coins',
  'To validate and add transactions to the blockchain',
  'To control the supply of cryptocurrency',
  'To regulate the value of cryptocurrency',
  'To validate and add transactions to the blockchain',
  'EASY',
  'Blockchain'
);

-- Question 45
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What does the term "immutable" mean in the context of blockchain?',
  'The ability to change data retroactively',
  'The inability to change data once it is added to the blockchain',
  'The speed of blockchain transactions',
  'The flexibility of blockchain architecture',
  'The inability to change data once it is added to the blockchain',
  'EASY',
  'Blockchain'
);


-- Question 46
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is a blockchain fork?',
  'A physical split in the blockchain network',
  'A software upgrade to the blockchain protocol',
  'A transaction on the blockchain',
  'A consensus mechanism in blockchain',
  'A software upgrade to the blockchain protocol',
  'EASY',
  'Blockchain'
);

-- Question 47
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the role of a hash function in blockchain?',
  'To create new cryptocurrencies',
  'To validate transactions',
  'To sign smart contracts',
  'To encrypt user data',
  'To validate transactions',
  'EASY',
  'Blockchain'
);

-- Question 48
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which term describes the process of verifying and adding transactions to the blockchain?',
  'Mining',
  'Staking',
  'Sharding',
  'Forking',
  'Mining',
  'EASY',
  'Blockchain'
);

-- Question 49
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is a decentralized application (DApp) in blockchain?',
  'A traditional mobile app',
  'An application without user authentication',
  'An application with a centralized server',
  'An application that runs on a blockchain network',
  'An application that runs on a blockchain network',
  'EASY',
  'Blockchain'
);

-- Question 50
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which blockchain feature ensures that transactions cannot be altered or deleted?',
  'Smart Contracts',
  'Consensus Mechanism',
  'Immutability',
  'Sharding',
  'Immutability',
  'EASY',
  'Blockchain'
);

-- Question 51
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of a public key in blockchain cryptography?',
  'To sign transactions and provide access to funds',
  'To encrypt data for public sharing',
  'To publicly identify a user',
  'To verify the authenticity of blockchain nodes',
  'To publicly identify a user',
  'EASY',
  'Blockchain'
);

-- Question 52
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which blockchain network is known for its focus on supporting smart contracts and decentralized applications?',
  'Bitcoin',
  'Ethereum',
  'Ripple (XRP)',
  'Litecoin',
  'Ethereum',
  'EASY',
  'Blockchain'
);

-- Question 53
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the function of a Merkle tree in a blockchain?',
  'To organize transactions in chronological order',
  'To encrypt user data on the blockchain',
  'To create a distributed ledger',
  'To efficiently verify the integrity of the blockchain',
  'To efficiently verify the integrity of the blockchain',
  'EASY',
  'Blockchain'
);

-- Question 54
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary benefit of using a blockchain for transactions?',
  'Decreased transparency',
  'Increased centralization',
  'Improved security and transparency',
  'Faster transaction speed',
  'Improved security and transparency',
  'EASY',
  'Blockchain'
);

-- Question 55
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'In blockchain, what is the role of a consensus algorithm?',
  'To create new blocks',
  'To agree on the state of the blockchain',
  'To validate transactions',
  'To encrypt user data',
  'To agree on the state of the blockchain',
  'EASY',
  'Blockchain'
);

-- Question 56
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the concept of "double-spending" in blockchain?',
  'Sending two transactions to the same recipient',
  'Using two different cryptocurrencies for a transaction',
  'Spending the same cryptocurrency twice',
  'Sending a transaction without any cryptocurrency',
  'Spending the same cryptocurrency twice',
  'EASY',
  'Blockchain'
);

-- Question 57
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What does the term "block time" refer to in blockchain?',
  'The time it takes to mine a block',
  'The time it takes to validate a transaction',
  'The time it takes for a block to be added to the blockchain',
  'The time it takes to encrypt data',
  'The time it takes for a block to be added to the blockchain',
  'EASY',
  'Blockchain'
);

-- Question 58
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary goal of decentralization in blockchain networks?',
  'To increase transaction fees',
  'To decrease security',
  'To reduce reliance on a central authority',
  'To speed up transaction processing',
  'To reduce reliance on a central authority',
  'EASY',
  'Blockchain'
);

-- Question 59
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which term describes the process of distributing data across multiple nodes in a blockchain network?',
  'Centralization',
  'Distribution',
  'Decentralization',
  'Normalization',
  'Decentralization',
  'EASY',
  'Blockchain'
);

-- Question 60
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is a "hard fork" in blockchain terminology?',
  'A software upgrade requiring consensus',
  'A temporary network disruption',
  'A change in the blockchain protocol',
  'A change in the consensus algorithm',
  'A change in the blockchain protocol',
  'EASY',
  'Blockchain'
);

-- Question 61
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which cryptographic concept is used to link one block to the previous block in a blockchain?',
  'Public Key Cryptography',
  'Hashing',
  'Symmetric Encryption',
  'Asymmetric Encryption',
  'Hashing',
  'EASY',
  'Blockchain'
);

-- Question 62
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the difference between a public key and a private key in blockchain cryptography?',
  'Public key is used for encryption, private key for decryption',
  'Public key is secret, private key is shared',
  'Public key is only used for signatures, private key for all encryption',
  'There is no difference between them',
  'Public key is used for encryption, private key for decryption',
  'MEDIUM',
  'Blockchain'
);

-- Question 63
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of a blockchain explorer?',
  'To create new blocks',
  'To visualize and explore the contents of a blockchain',
  'To mine cryptocurrency',
  'To generate new public keys',
  'To visualize and explore the contents of a blockchain',
  'MEDIUM',
  'Blockchain'
);

-- Question 64
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which blockchain feature enhances privacy by allowing transactions to be selectively disclosed?',
  'Sharding',
  'Ring Signatures',
  'Proof of Work (PoW)',
  'Atomic Swaps',
  'Ring Signatures',
  'MEDIUM',
  'Blockchain'
);

-- Question 65
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of zero-knowledge proofs in blockchain?',
  'To speed up transaction processing',
  'To prove ownership without revealing specific details',
  'To create new blocks',
  'To increase the security of private keys',
  'To prove ownership without revealing specific details',
  'MEDIUM',
  'Blockchain'
);

-- Question 66
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which type of attack involves a user controlling a majority of the network’s mining power?',
  '51% Attack',
  'Sybil Attack',
  'Double Spending Attack',
  'Man-in-the-Middle Attack',
  '51% Attack',
  'MEDIUM',
  'Blockchain'
);

-- Question 67
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the purpose of a time-stamp in a blockchain block?',
  'To indicate the current time of day',
  'To add aesthetic value to the block',
  'To prevent double-spending',
  'To establish the order of transactions',
  'To establish the order of transactions',
  'MEDIUM',
  'Blockchain'
);

-- Question 68
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the primary goal of a blockchain consortium?',
  'To achieve full decentralization',
  'To share control among a group of organizations',
  'To create a public blockchain network',
  'To compete for mining rewards',
  'To share control among a group of organizations',
  'MEDIUM',
  'Blockchain'
);

-- Question 69
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'Which type of consensus algorithm involves participants putting their cryptocurrency at stake as collateral?',
  'Proof of Authority (PoA)',
  'Delegated Proof of Stake (DPoS)',
  'Proof of Work (PoW)',
  'Proof of Stake (PoS)',
  'Proof of Stake (PoS)',
  'MEDIUM',
  'Blockchain'
);

-- Question 70
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES (
  'What is the role of a nonce in a Proof of Work (PoW) blockchain?',
  'To sign transactions',
  'To provide additional security to the blockchain',
  'To solve cryptographic puzzles during mining',
  'To validate smart contracts',
  'To solve cryptographic puzzles during mining',
  'HARD',
  'Blockchain'
);







