import Test.Hspec

calibrate _ = 0

main = hspec $ do
    describe "Calibration" $ do
        it "should start at 0" $ do
            calibrate "" `shouldBe` 0
