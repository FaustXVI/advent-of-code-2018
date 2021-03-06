import Test.Hspec
import Control.Monad.Reader
import Calibration hiding(main)


withInput :: (Reader () String -> Reader () Int) ->String -> Int
f `withInput` s = runReader (f (reader (\_ -> s))) ()

main = hspec $ do
    describe "Calibration" $ do
        it "should start at 0" $ do
            calibrate `withInput` "0" `shouldBe` 0
            calibrate `withInput` "" `shouldBe` 0
        it "should add 1" $ do
            calibrate `withInput` "+1" `shouldBe` 1
        it "should remove 1" $ do
            calibrate `withInput` "-1" `shouldBe` (-1)
        it "should add two numbers" $ do
            calibrate `withInput` "1\n1" `shouldBe` 2
        it "should add two negative numbers" $ do
            calibrate `withInput` "-1\n-1" `shouldBe` (-2)
