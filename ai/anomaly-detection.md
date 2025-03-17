## Anomaly Detection

### Anomaly

Novelty, Anomaly, Outlier 는 정상적인 범주를 벗어난 **이상치** 데이터

### Outlier Detection Algorithm

- Statistical methods
- ML(Machine Learning and Deep Learning) models

#### Statistical methods

통계학적 이상감지는 통계학에서 [3-Sigma Rule](https://codefinity.com/courses/v2/165dbadd-b48e-4a7f-8b0d-1b8477c22a1d/047e166d-bc62-4bd1-8114-f0771ef62d83/a087d692-2177-4251-ac77-9466243454e4)에 의해 정규분포의 표준편차가 일정 범위에 속한다라는 경험적인 근거에 따라 이상치를 판별하는 방법

- [Z-Score](https://loyalty.dev/posts/anomaly-detection-with-z-score)
- [ARIMA(AutoRegressive Integrated Moving Average)](https://medium.com/aimonks/anomaly-detection-for-time-series-analysis-eeecd6282f53)

#### Machine Learning models

- [Isolation Forest](https://medium.com/@corymaklin/isolation-forest-799fceacdda4)
- [K-Means](https://medium.com/swlh/introduction-to-anomaly-detection-in-time-series-data-and-k-means-clustering-5832fb33d8cb)
- [DBSCAN](https://medium.com/@dilip.voleti/dbscan-algorithm-for-fraud-detection-outlier-detection-in-a-data-set-60a10ad06ea8)
- [LSTM AutoEncoder](https://medium.com/@zhonghong9998/anomaly-detection-in-time-series-data-using-lstm-autoencoders-51fd14946fa3)
- [Anomaly Transformer](https://github.com/thuml/Anomaly-Transformer) for Time Series

##### Others
- One-Class SVM(Support Vector Machine)
- Deep SVDD(Support Vector Data Description)
- LOF(Local Outlier Factor)
- Mahalanobis Distance
- GAN(Generative Adversarial Network)
- PCA(Principal Component Analysis)

## References

- [Anomaly Detection Learning Resources](https://github.com/yzhao062/anomaly-detection-resources)
- [scikit-learn: machine learning in Python](https://github.com/scikit-learn/scikit-learn)
- https://github.com/openvinotoolkit/anomalib
